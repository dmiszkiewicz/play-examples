package com.dmiszkiewicz

import com.dmiszkiewicz.repository.Repository
import play.api.mvc._

class MyController(repository: Repository) extends Controller {

  def getAllGraphsNames(city: String) = Action {
    repository.getTemperature(city) match {
        //TODO return temperature if available
      case Some(t) => Ok
      case None => NotFound
    }
  }

}