package uk.gov.hmrc.$packageName$.pages.generic

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.{Assertion, Matchers}
import org.scalatest.selenium.WebBrowser
import uk.gov.hmrc.$packageName$.util.{Configuration, SingletonDriver}

trait Driver extends ScalaDsl with EN with Matchers with WebBrowser {

  var url = ""

  implicit val driver: WebDriver = SingletonDriver.getInstance().get

  After { _ ⇒
    driver.manage().deleteAllCookies()
  }

  def navigateTo(): Unit = driver.navigate.to(s"\${Configuration.host}/\$url")

  def on(page: WebPage): Assertion = {
    val wait = new WebDriverWait(driver, 10)
    val _ = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")))
    assert(page.isCurrentPage, s"\n\${page.url} was either not loaded or the header was incorrect. " +
      s"\n\${page.currentUrl} was loaded instead" +
      s"\nExpected heading was: \${page.header.get}" +
      s"\nActual heading was:   \${find(cssSelector("h1")).get.text}")
  }

}
