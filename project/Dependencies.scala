import sbt._
object Dependencies {
  // versions
  lazy val akkaHttpVersion: String = "10.1.9"
  lazy val akkaVersion: String = "2.5.23"
  lazy val scalaTestVersion: String = "3.0.8"
  // libraries
  lazy val akkaHttp: ModuleID = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val akkaHttpTestKit: ModuleID = "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test"
  lazy val akkaActor: ModuleID = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  lazy val akkaStream: ModuleID = "com.typesafe.akka" %% "akka-stream" % akkaVersion
  lazy val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % scalaTestVersion
  lazy val akkaActorTestKit: ModuleID = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  lazy val akkaStreamTestKit: ModuleID = "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion
  // project
  lazy val devopsDependencies: Seq[ModuleID] =
    Seq(akkaHttp, akkaHttpTestKit, akkaActor, akkaStream, akkaActorTestKit, akkaStreamTestKit, scalaTest)
}
