A [Giter8][g8] template for ...!

# HMRC Cucumber-Testing-Template


## Why use the template

This template will generate a base project which makes use of the Scalatest & Cucumber frameworks
and includes the minimum required dependencies to function correctly.

Packages and structure is also supplied in the hopes that it will help foster a standard way of organising a test project
to make it easier for other testers to view other people's code.

This template makes use of the build.sbt and plugins.sbt files.

No enterprise dependencies are used so can be stored either in enterprise or in the open. (assuming of course no PI information is stored)

### What's New

- ??/02: updated with new versions of dependencies
- 28/02: Refactored SingletonDriver
- 10/05: Updated old URL's, other minor refactoring
- 12/06/19: Updated dependencies and package structure

## How to use

### Do not clone this project!

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

      "com.typesafe.play"       %% "play-test"              % PlayVersion.current,
      "org.scalatest"           %% "scalatest"              % "3.2.0-SNAP10",
      "org.scalacheck"          %% "scalacheck"             % "1.14.0",
      "io.cucumber"             %% "cucumber-scala"         % "4.3.1",
      "io.cucumber"             % "cucumber-junit"          % "4.3.1",
      "io.cucumber"             % "cucumber-picocontainer"  % "4.3.1",
      "org.seleniumhq.selenium" % "selenium-java"           % "3.141.59",
      "com.google.guava"        % "guava"                   % "27.1-jre"

## WebDrivers

It is recommended that you add the necessary drivers to your path to enable easy running of the tests

Follow these instructions to do just that:

    sudo apt-get install unzip
    
    wget -N http://chromedriver.storage.googleapis.com/$chromeDriverVersion/chromedriver_linux64.zip
    unzip chromedriver_linux64.zip
    chmod +x chromedriver
    
    sudo mv -f chromedriver /usr/local/share/chromedriver
    sudo ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver
    sudo ln -s /usr/local/share/chromedriver /usr/bin/chromedriver

This can also be done for the Geckodriver also