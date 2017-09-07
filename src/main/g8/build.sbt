import play.core.PlayVersion

name := "$name$"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"

val nexusPreviewHost: String = System.getProperty("hmrc.repo.host", "https://nexus-preview.tax.service.gov.uk")

resolvers ++= Seq("hmrc-snapshots" at nexusPreviewHost + "/content/repositories/hmrc-snapshots",
  "hmrc-releases" at nexusPreviewHost + "/content/repositories/hmrc-releases",
  "typesafe-releases" at nexusPreviewHost + "/content/repositories/typesafe-releases",
  Resolver.url("hmrc-sbt-plugin-releases", url("https://dl.bintray.com/hmrc/sbt-plugin-releases"))(Resolver.ivyStylePatterns))

libraryDependencies ++= Seq(
  "org.pegdown" % "pegdown" % "1.4.2" % "test",
  "com.typesafe.play" %% "play-test" % PlayVersion.current,
  "org.scalatest" %% "scalatest" % "3.0.4",
  "info.cukes" % "cucumber-scala_2.11" % "1.2.4",
  "info.cukes" % "cucumber-junit" % "1.2.4",
  "info.cukes" % "cucumber-picocontainer" % "1.2.4",
  "org.seleniumhq.selenium" % "selenium-java" % "3.5.3",
  "org.typelevel" %% "cats" % "0.9.0",
  "com.google.guava" % "guava" % "23.0")

fork in Test := true
parallelExecution in Test := false
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/html-report")
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports")
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oDF")