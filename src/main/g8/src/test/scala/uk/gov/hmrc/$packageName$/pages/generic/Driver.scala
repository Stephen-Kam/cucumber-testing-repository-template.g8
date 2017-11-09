package uk.gov.hmrc.$packageName$.pages.generic

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Matchers
import uk.gov.hmrc.$packageName$.util.{Configuration, SingletonDriver}

trait Driver extends ScalaDsl with EN with Matchers {

  protected var url = ""

  implicit val driver: WebDriver = SingletonDriver.getInstance()

  After { _ ⇒
    driver.manage().deleteAllCookies()
  }

  def navigateTo(): Unit = driver.navigate.to(s"\${Configuration.host}/\$url")

}
