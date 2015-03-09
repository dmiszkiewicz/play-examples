name := """test"""

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies += "io.spray" %%  "spray-json" % "1.3.1"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.0.1" % "test"

libraryDependencies += "com.typesafe.play" % "play_2.11" % "2.4.0-M2"

libraryDependencies += "com.typesafe.play" % "play-test_2.11" % "2.4.0-M2" % "test"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
