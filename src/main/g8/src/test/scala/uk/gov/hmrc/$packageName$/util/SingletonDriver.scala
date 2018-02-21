package uk.gov.hmrc.$packageName$.util

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions}
import org.openqa.selenium.remote.DesiredCapabilities

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
      val capabilities = DesiredCapabilities.chrome()
      val options = new ChromeOptions()
      options.addArguments("test-type")
      options.addArguments("--disable-gpu")
      capabilities.setJavascriptEnabled(isJsEnabled)
      capabilities.setCapability(ChromeOptions.CAPABILITY, options)
      new ChromeDriver(capabilities)
    }

    def createGeckoDriver(): WebDriver = {
      val capabilities = DesiredCapabilities.firefox()
      val options = new FirefoxOptions()
      new FirefoxDriver(capabilities)
    }

    val environmentProperty = System.getProperty("browser")
    environmentProperty match {
      case "firefox" ⇒ createGeckoDriver()
      case "chrome" ⇒ createChromeDriver()
      case _ => throw new IllegalArgumentException(s"Browser type not recognised: -D\$environmentProperty")
    }
  }

  def initialiseBrowser() {
    instance = createBrowser()
    instance.manage().window().maximize()
    baseWindowHandle = instance.getWindowHandle
  }

}
