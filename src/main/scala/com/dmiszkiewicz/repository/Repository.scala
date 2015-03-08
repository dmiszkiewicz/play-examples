package com.dmiszkiewicz.repository

import com.dmiszkiewicz.domain.Temperature

trait Repository {
  def getTemperature(city: String): Option[Temperature]
}
