package com.dmiszkiewicz

trait Repository {
  def getTemperature(city: String): Option[Temperature]
}
