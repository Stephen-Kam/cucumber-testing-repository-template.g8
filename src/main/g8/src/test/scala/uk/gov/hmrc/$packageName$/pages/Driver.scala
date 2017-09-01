package uk.gov.hmrc.$packageName$.pages

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers
import uk.gov.hmrc.$packageName$.util.SingletonDriver

trait Driver extends ScalaDsl with EN with Matchers {

  implicit val driver: WebDriver = SingletonDriver.getInstance()

}