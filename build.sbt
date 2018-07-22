import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "joda-scala",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "joda-time" % "joda-time" % "2.10",
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9"
  )
