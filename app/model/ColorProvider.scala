package model

import spray.json._

case class Color(val name: String, val red: Int, val green: Int, val blue: Int)

class ColorProvider {
  def black(): Color = {
    Color("black", 0, 0, 0)
  }
}

object ColorJsonProtocol extends DefaultJsonProtocol {
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