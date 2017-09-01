A [Giter8][g8] template for ...!

# HMRC Cucumber-Testing-Template


## Why use the template

This template will generate a base project which makes use of the Scalatest & Cucumber frameworks
and includes the minimum required dependencies to function correctly.

Packages and structure is also supplied in the hopes that it will help foster a standard way of organising a test project
to make it easier for other testers to view other people's code.

This template makes use of the build.sbt and plugins.sbt files.

No enterprise dependencies are used so can be stored either in enterprise or in the open. (assuming of course no PI information is stored)

A chromedriver has also been included for both Windows and Linux/Apple, located in the drivers package

A runTests shell script has been included which allows the running of any tests and takes a number of arguments

### The Shell Script

In a terminal enter the command:

>./runTests {environment} {browser} [optional]{driver location} [optional]{tags}

For example

>./runTests dev chrome /usr/local/bin/chromedriver runOnlyInDev

Will run any tests with the @runOnlyInDev tag in the dev environment in Chrome

If no driver location has been specified it will use the one in the drivers package based on your operating system

## How to use

SBT version 13.13 or above is required

>Navigate to the directory where you would like the project to be stored

Then enter the following:

>sbt new Stephen-Kam/cucumber-testing-repository-template.g8

You'll be asked a number of questions on how to name various parts of the project

### Additional Notes

If importing into IntelliJ, there are couple extra additional configurations that will need to be set before the tests can be ran:

- If running via individual scenarios:

>Cucumber Java default configuration, set the glue to uk.gov.hmrc.$packageName$.stepdefs

### Dependencies Used

    "org.pegdown" % "pegdown" % "1.4.2"
    "org.scalactic" %% "scalactic" % "3.0.1" 
    "com.typesafe.play" %% "play-test" % PlayVersion.current
    "org.scalatest" %% "scalatest" % "3.0.1"
    "info.cukes" % "cucumber-scala_2.11" % "1.1.8"
    "info.cukes" % "cucumber-junit" % "1.1.8"
    "info.cukes" % "cucumber-picocontainer" % "1.1.8"
    "org.seleniumhq.selenium" % "selenium-java" % "2.53.1"
    "org.typelevel" %% "cats" % "0.9.0"


### What's still to do

This template is in a working state, however there are some aspects that are still missing:

- Add in functionality to allow easy running of tests in other browsers
- Add in extra drivers such as the Marionette/Gecko driver and drivers for other operating systems

