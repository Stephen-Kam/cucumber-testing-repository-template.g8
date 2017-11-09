package uk.gov.hmrc.$packageName$.pages.generic

import java.io.FileInputStream
import java.util.Properties

import org.openqa.selenium.{Keys, WebElement}
import org.scalatest._
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Millis, Seconds, Span}

trait WebPage extends Matchers
  with WebBrowser
  with Eventually
  with PatienceConfiguration
  with Assertions
  with Driver {

  override implicit val patienceConfig: PatienceConfig = PatienceConfig(timeout = scaled(Span(5, Seconds)), interval = scaled(Span(500, Millis)))

  def isCurrentPage: Boolean = false

  //Message file functionality
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
