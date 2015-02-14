package controllers

import play.api._
import play.api.mvc._
import spray.json._


object Application extends Controller {

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
  import MyJsonProtocol._


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def getBlackColor = Action {
    Ok(new Color("black",0,0,0).toJson.compactPrint).as("application/json")
  }
}