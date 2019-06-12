import play.core.PlayVersion

name := "$name$"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.8"

val cucumberVersion = "4.3.1"

libraryDependencies ++= Seq(
  "com.typesafe.play"       %% "play-test"              % PlayVersion.current,
  "org.scalatest"           %% "scalatest"              % "3.2.0-SNAP10",
  "org.scalacheck"          %% "scalacheck"             % "1.14.0",
  "io.cucumber"             %% "cucumber-scala"         % cucumberVersion,
  "io.cucumber"             % "cucumber-junit"          % cucumberVersion,
  "io.cucumber"             % "cucumber-picocontainer"  % cucumberVersion,
  "org.seleniumhq.selenium" % "selenium-java"           % "3.141.59",
  "com.google.guava"        % "guava"                   % "27.1-jre"
)