package uk.gov.hmrc.$packageName$.pages.generic

import java.io.FileInputStream
import java.util.Properties

import org.openqa.selenium.{Keys, WebElement}
import org.scalatest._
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Millis, Seconds, Span}
import uk.gov.hmrc.cucumber.util.Driver

trait WebPage extends Matchers
  with WebBrowser
  with Eventually
  with PatienceConfiguration
  with Assertions
  with Driver {

  override implicit val patienceConfig: PatienceConfig = PatienceConfig(timeout = scaled(Span(5, Seconds)), interval = scaled(Span(500, Millis)))

  def isCurrentPage: Boolean = false

  def back(): Unit = clickOn("ButtonBack")

  def textField(id: String, value: String): Unit = {
    val elem = find(id)
    if (elem.isDefined) {
      val e = new TextField(elem.get.underlying)
      if (e.isDisplayed) e.value = value
    }
  }

  def numberField(id: String, value: String): Unit = {
    val elem = find(id)
    if (elem.isDefined) {
      val e = new NumberField(elem.get.underlying)
      if (e.isDisplayed) e.value = value
    }
  }

  def pressKeys(value: Keys): Unit = {
    val e: WebElement = driver.switchTo.activeElement
    e.sendKeys(value)
  }

  def singleSel(id: String, value: String): Unit = {
    val elem = find(id)
    if (elem.isDefined) {
      val e = new SingleSel(elem.get.underlying)
      if (e.isDisplayed) e.value = value
    }
  }

  def checkHeader(heading: String, text: String) = {
    find(cssSelector(heading)).exists(_.text == text)
  }



  val fis = new FileInputStream("src/test/resources/message.properties")
  val props: Properties = new Properties()
  loadProperties(fis, props)

  def loadProperties(aFis: FileInputStream, aProps: Properties) = {
    try {aProps.load(aFis)}
    catch {case e: Exception => println("Exception loading file")}
    finally {
      if (aFis != null) {
        try {aFis.close()}
        catch {case e: Exception => println("Exception on closing file")}
      }
    }
  }

  def getProperty(key: String, aProps: Properties): String = {
    try {
      val utf8Property = new String(aProps.getProperty(key).getBytes("ISO-8859-1"), "UTF-8")
      utf8Property.replaceAll("''","'")
    }
    catch {case e: Exception => "Exception getting property"}
  }

  def gm(key: String): String = getProperty(key, props).replaceAll("''", "'")


}
