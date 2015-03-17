package controllers

import MyJsonProtocol._
import play.api.mvc._
import spray.json._

class MyController(repository: Repository) extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def getTemperature(city: String) = Action {
    repository.getTemperature(city) match {
      case Some(t) => Ok(t.toJson.toString()).as("application/json")
      case None => NotFound
    }
  }

}

object MyController extends MyController(new Repository {
  override def getTemperature(city: String): Option[Temperature] = Some(Temperature(10))
})