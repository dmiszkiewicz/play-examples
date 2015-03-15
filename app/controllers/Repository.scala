package controllers

trait Repository {
  def getTemperature(city: String): Option[Temperature]
}
