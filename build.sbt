import Dependencies._

name := "devops"
version := "0.1"
scalaVersion := "2.12.8"

lazy val root = project
  .in(file("."))
  .settings(
    name := "devops",
    libraryDependencies ++= devopsDependencies
  )