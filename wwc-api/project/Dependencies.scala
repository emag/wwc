import sbt._

object Dependencies {
  object Versions {
    val jgit      = "5.6.0.201912101111-r"
    val playJson  = "2.8.1"
    val osLib     = "0.6.3"
    val scalatest = "3.1.0"
  }

  object JGit {
    val main = "org.eclipse.jgit" % "org.eclipse.jgit" % Versions.jgit
  }

  object PlayJson {
    val main = "com.typesafe.play" % "play-json_2.13" % Versions.playJson
  }

  object OsLib {
    val main = "com.lihaoyi" %% "os-lib" % Versions.osLib
  }
  object ScalaTest {
    val main = "org.scalatest" %% "scalatest" % Versions.scalatest
  }
}
