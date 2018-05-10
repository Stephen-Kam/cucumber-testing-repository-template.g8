package uk.gov.hmrc.$packageName$.pages.generic

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Matchers
import org.scalatest.selenium.WebBrowser

trait Driver extends ScalaDsl with EN with Matchers with WebBrowser {

  protected var url = ""

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
