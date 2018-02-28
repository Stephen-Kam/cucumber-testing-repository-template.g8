package uk.gov.hmrc.$packageName$.util

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions}

object SingletonDriver {

  private var _driver: Option[WebDriver] = None

  def getInstance(): Option[WebDriver] = {
    if (_driver.isEmpty) {
      val d = createBrowser()
      d.manage().window().maximize()
      val _ = d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
      _driver = Some(d)
    }
    _driver
  }

  def createBrowser(): WebDriver = {
    def createChromeDriver(headless: Boolean): WebDriver = {
      val options = new ChromeOptions()
      options.addArguments("test-type")
      if (headless) options.addArguments("--disable-gpu", "--headless")
      new ChromeDriver(options)
    }

    val environmentProperty = System.getProperty("browser")
    environmentProperty match {
      case "firefox" ⇒ new FirefoxDriver(new FirefoxOptions())
      case "chrome" ⇒ createChromeDriver(false)
      case "headless" ⇒ createChromeDriver(true)
      case _ => throw new IllegalArgumentException(s"Browser type not recognised: -D\$environmentProperty")
    }
  }
}
