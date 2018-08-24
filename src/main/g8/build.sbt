import play.core.PlayVersion

name := "$name$"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.11"

val cucumberVersion = "1.2.5"

libraryDependencies ++= Seq(
  "org.pegdown" % "pegdown" % "1.6.0",
  "com.typesafe.play" %% "play-test" % PlayVersion.current,
  "org.scalatest" %% "scalatest" % "3.0.4" excludeAll ExclusionRule(organization = "org.seleniumhq.selenium"),
  "info.cukes" % "cucumber-scala_2.11" % cucumberVersion,
  "info.cukes" % "cucumber-junit" % cucumberVersion,
  "info.cukes" % "cucumber-picocontainer" % cucumberVersion,
  "org.seleniumhq.selenium" % "selenium-java" % "3.7.1",
  "org.typelevel" %% "cats" % "0.9.0",
  "com.google.guava" % "guava" % "23.0")

fork in Test := false
parallelExecution in Test := false
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/html-report")
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports")
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oDF")