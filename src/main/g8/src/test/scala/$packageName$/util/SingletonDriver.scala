package $packageName$.utils

import java.net.URL

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions}
import org.openqa.selenium.remote.{DesiredCapabilities, LocalFileDetector, RemoteWebDriver}

object SingletonDriver {

  private var _driver: Option[WebDriver] = None

  def getInstance(): Option[WebDriver] = {
    if (_driver.isEmpty) {
      val d: WebDriver = newDriver()
      _driver = Some(d)
    }
    _driver
  }

  def newDriver(): WebDriver = {
    def createChromeDriver(headless: Boolean, remote: Boolean): WebDriver = {
      val options = new ChromeOptions()
      val capabilities = DesiredCapabilities.chrome()
      options.addArguments("test-type")
      options.addArguments("start-maximized")
      capabilities.setJavascriptEnabled(true)
      if (headless) options.addArguments("--disable-gpu", "--headless")
      if (remote) {
        options.addArguments("--disable-gpu")
        capabilities.setCapability(ChromeOptions.CAPABILITY, options)
        val driver = new RemoteWebDriver(new URL(s"http://localhost:4444/wd/hub"), options)
        driver.setFileDetector(new LocalFileDetector)
        driver
      } else new ChromeDriver(options)
    }

    val browser = System.getProperty("browser", "headless")
    browser match {
      case "chrome" => createChromeDriver(headless = false, remote = false)
      case "headless" => createChromeDriver(headless = true, remote = false)
      case "remote-chrome" => createChromeDriver(headless = false, remote = true)
      case "headless-remote-chrome" => createChromeDriver(headless = true, remote = true)
      case "firefox" => new FirefoxDriver(new FirefoxOptions())
      case _ => throw new IllegalArgumentException(s"Browser type not recognised: \$browser")
    }
  }

}
