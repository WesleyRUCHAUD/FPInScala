lazy val root =
  (project in file("."))
    .settings(
      Seq(
        name := "FPInScala",
        version := "1.0",
        scalaVersion := "2.12.3"
      ): _*
    )
    .settings(
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "3.0.3" % "test",
        "org.mockito" % "mockito-core" % "2.7.22" % "test"
      )
    )
        