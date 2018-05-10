package uk.gov.hmrc.$packageName$.pages.generic

import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest._
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Millis, Seconds, Span}
import uk.gov.hmrc.$packageName$.pages.generic.MessageProperty

trait WebPage extends Matchers
  with WebBrowser
  with Eventually
  with PatienceConfiguration
  with Assertions
  with Driver
  with MessageProperty {

  override implicit val patienceConfig: PatienceConfig = PatienceConfig(timeout = scaled(Span(5, Seconds)), interval = scaled(Span(500, Millis)))

  val header: Option[String] = None

  def isCurrentPage: Boolean = {
    val wait: WebDriverWait = new WebDriverWait(driver, 5)
    wait.until(ExpectedConditions.urlContains(this.url))
    checkHeader(header.getOrElse("The website doesn't have an H1 header"))
  }

  def checkHeader(text: String): Boolean = find(cssSelector("h1")).exists(_.text == text)

}
