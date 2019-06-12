package $packageName$.pages.generic

import $packageName$.utils.{Driver, Messages}
import org.scalatest.Assertion
import org.scalatest.selenium.WebBrowser

trait BasePage extends WebBrowser
  with Driver
  with Messages {

  val header: String
  val url: String

  def on(): Assertion = {
    currentUrl should include(url)
    find(cssSelector("h1")).get.text shouldBe header
  }

  def navigateTo(): Unit = go to s"\$host/\$url"

}
