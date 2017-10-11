package uk.gov.hmrc.$packageName$.util

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Matchers
import uk.gov.hmrc.pla.pages.generic.WebPage

trait Driver extends ScalaDsl with EN with Matchers {

  implicit val driver: WebDriver = SingletonDriver.getInstance()

  After { _ ⇒
    driver.manage().deleteAllCookies()
  }

}
