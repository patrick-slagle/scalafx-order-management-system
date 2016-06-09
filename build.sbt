
scalaVersion := "2.11.1"

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.92-R10"
unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVA_HOME") + "/jre/lib/ext/jfxrt.jar"))

libraryDependencies ++= List(
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "mysql" % "mysql-connector-java" % "5.1.27",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
lazy val macros = (project in file("macros")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")) dependsOn macros

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.12.0"


libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.2.2"

resolvers += Resolver.sonatypeRepo("releases")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
