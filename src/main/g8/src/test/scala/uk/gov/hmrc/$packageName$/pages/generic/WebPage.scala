package uk.gov.hmrc.$packageName$.pages.generic

import java.io.FileInputStream
import java.util.Properties

import org.scalatest._
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Millis, Seconds, Span}

trait WebPage extends Matchers
  with WebBrowser
  with Eventually
  with PatienceConfiguration
  with Assertions
  with Driver
  with MessageProperty {

  override implicit val patienceConfig: PatienceConfig = PatienceConfig(timeout = scaled(Span(5, Seconds)), interval = scaled(Span(500, Millis)))

  def isCurrentPage: Boolean = {
    val wait: WebDriverWait = new WebDriverWait(driver, 5)
    wait.until(ExpectedConditions.urlContains(this.relativeUrl))
    checkHeader(header.getOrElse("The website doesn't have an H1 header"))
  }

  def checkHeader(text: String): Boolean = find(cssSelector("h1")).exists(_.text == text)

}
