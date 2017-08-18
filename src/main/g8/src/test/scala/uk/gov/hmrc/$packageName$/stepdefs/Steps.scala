package uk.gov.hmrc.$packageName$.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers
import uk.gov.hmrc.$packageName$.util.Driver

trait Steps extends ScalaDsl with EN with Matchers {

  implicit val driver: WebDriver = Driver.getInstance()

}