#Sample app build in play

#Used libraries
* spray-json - spray-json is a lightweight, clean and efficient JSON implementation in Scala.
* mockito - Tasty mocking framework for unit tests in Java
* swagger - Swagger is a simple yet powerful representation of your RESTful API.
* play - Play Framework makes it easy to build web applications with Java & Scala.

I used activator template [Play Scala Seed](https://typesafe.com/activator/template/play-scala)

#Description of content
* app/controllers/Application contains class representing REST endpoints
* app/model/ColorProvider contains case class for representing colors, ColorProvider, and ColorJsonProvider which help with serialization
* test/ApplicationSpec contains some test with mockito
* test/Integration contains sample integration test
