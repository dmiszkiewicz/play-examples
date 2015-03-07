package controllers

import com.wordnik.swagger.annotations.{ApiOperation, ApiResponses, ApiResponse, Api}
import model.{ColorJsonProtocol, Color, ColorProvider}
import play.api._
import play.api.mvc._
import spray.json._


@Api(value = "/colors", description = "Operations about colors")
class Application(colorProvider: ColorProvider) extends Controller {
  import ColorJsonProtocol._
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