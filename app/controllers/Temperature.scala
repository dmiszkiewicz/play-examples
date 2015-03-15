package controllers

import spray.json.DefaultJsonProtocol

case class Temperature(temperature: Double)

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val personFormat = jsonFormat1(Temperature)
}