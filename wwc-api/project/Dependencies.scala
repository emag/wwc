import sbt._

object Dependencies {
  object Versions {
    val scalaTest = "3.1.0"
  }

  object ScalaTest {
    val scalatest = "org.scalatest" %% "scalatest" % Versions.scalaTest
  }
}
