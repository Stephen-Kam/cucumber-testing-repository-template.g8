package uk.gov.hmrc.$packageName$.util

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.{BrowserType, DesiredCapabilities}

object SingletonDriver {

  private val systemProperties = System.getProperties
  private val os: String = Option(systemProperties.getProperty("os.name")).getOrElse(sys.error("Could not read OS name"))
  private val isMac: Boolean = os.startsWith("Mac")
  private val isLinux: Boolean = os.startsWith("Linux")
  private val linuxArch: String = Option(systemProperties.getProperty("os.arch")).getOrElse(sys.error("Could not read OS arch"))
  private val isJsEnabled: Boolean = true
  private val driverDirectory: String = "drivers"
  private var baseWindowHandle: String = _

  var instance: WebDriver = _

  def getInstance(): WebDriver = {
    if (instance == null) {
      initialiseBrowser()
    }
    instance
  }

  private def createBrowser(): WebDriver = {
    def createChromeDriver(): WebDriver = {
      if (isMac) {
        systemProperties.setProperty("webdriver.chrome.driver", driverDirectory + "/chromedriver_mac")
      } else if (isLinux && linuxArch == "amd32") {
        systemProperties.setProperty("webdriver.chrome.driver", driverDirectory + "/chromedriver_linux32")
      } else if (isLinux) {
        systemProperties.setProperty("webdriver.chrome.driver", driverDirectory + "/chromedriver")
      } else {
        systemProperties.setProperty("webdriver.chrome.driver", driverDirectory + "/chromedriver.exe")
      }

      val capabilities = DesiredCapabilities.chrome()
      val options = new ChromeOptions()

      options.addArguments("test-type")
      options.addArguments("--disable-gpu")

      capabilities.setJavascriptEnabled(isJsEnabled)
      capabilities.setCapability(ChromeOptions.CAPABILITY, options)

      val driver = new ChromeDriver(capabilities)
      driver
    }

    def createFirefoxDriver(): WebDriver = {
      val capabilities = DesiredCapabilities.firefox()
      capabilities.setJavascriptEnabled(true)
      capabilities.setBrowserName(BrowserType.FIREFOX)

      new FirefoxDriver(capabilities)
    }

    def createGeckoDriver(): WebDriver = {
      if (isMac) {
        systemProperties.setProperty("webdriver.gecko.driver", driverDirectory + "/geckodriver_mac")
      } else if (isLinux) {
        systemProperties.setProperty("webdriver.gecko.driver", driverDirectory + "/geckodriver")
      } else {
        systemProperties.setProperty("webdriver.gecko.driver", driverDirectory + "/geckodriver.exe")
      }

      val capabilities = DesiredCapabilities.firefox()
      capabilities.setCapability("marionette", true)

      new FirefoxDriver(capabilities)
    }

    val environmentProperty = System.getProperty("browser")
    environmentProperty match {
      case "firefox" ⇒ createFirefoxDriver()
      case "chrome" ⇒ createChromeDriver()
      case "gecko" ⇒ createGeckoDriver()
      case _ => throw new IllegalArgumentException(s"Browser type not recognised: -D\$environmentProperty")
    }
  }

  def initialiseBrowser() {
    instance = createBrowser()
    instance.manage().window().maximize()
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    baseWindowHandle = instance.getWindowHandle
  }

}
