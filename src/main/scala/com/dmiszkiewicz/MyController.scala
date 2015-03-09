package com.dmiszkiewicz

import MyJsonProtocol._
import play.api.mvc._
import spray.json._

class MyController(repository: Repository) extends Controller {

  def getTemperature(city: String) = Action {
    repository.getTemperature(city) match {
      case Some(t) => Ok(t.toJson.toString()).as("application/json")
      case None => NotFound
    }
  }

}