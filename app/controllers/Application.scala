package controllers

import com.wordnik.swagger.annotations.{ApiOperation, ApiResponses, ApiResponse, Api}
import play.api._
import play.api.mvc._
import spray.json._

case class Color(val name: String, val red: Int, val green: Int, val blue: Int)

object MyJsonProtocol extends DefaultJsonProtocol {

  implicit object ColorJsonFormat extends RootJsonFormat[Color] {
    def write(c: Color) =
      JsArray(JsString(c.name), JsNumber(c.red), JsNumber(c.green), JsNumber(c.blue))

    def read(value: JsValue) = value match {
      case JsArray(Vector(JsString(name), JsNumber(red), JsNumber(green), JsNumber(blue))) =>
        new Color(name, red.toInt, green.toInt, blue.toInt)
      case _ => deserializationError("Color expected")
    }
  }

}

class ColorProvider {
  def black(): Color = {
    Color("black", 0, 0, 0)
  }
}

@Api(value = "/colors", description = "Operations about colors")
class Application(colorProvider: ColorProvider) extends Controller {


  import MyJsonProtocol._


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  @ApiOperation(nickname = "getBlackColor", value = "Get black color", notes = "Returns a color", response = classOf[Color], httpMethod = "GET")
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Color found")))
  def getBlackColor = Action {
    Ok(colorProvider.black().toJson.compactPrint).as("application/json")
  }
}

object Application extends Application(new ColorProvider)