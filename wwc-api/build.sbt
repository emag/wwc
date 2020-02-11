import Dependencies._

inThisBuild(
  Seq(
    organization := "wwc",
    name := "wwc-api",
    version := "0.0.1",
    scalaVersion := "2.13.1",
    scalacOptions ++= ScalacOptions.enabled,
    libraryDependencies ++= Seq(
        JGit.main,
        PlayJson.main,
        OsLib.main,
        ScalaTest.main % Test
      )
  )
)
