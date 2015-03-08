name := """play-examples"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

libraryDependencies += "io.spray" %%  "spray-json" % "1.3.1"

libraryDependencies += "org.mockito" % "mockito-core" % "1.8.5"