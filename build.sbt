name := """play-minimal"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies += "io.spray" %%  "spray-json" % "1.3.1"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.0.1" % "test"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"


libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)
