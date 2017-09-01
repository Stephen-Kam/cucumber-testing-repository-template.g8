package uk.gov.hmrc.$packageName$.pages

import uk.gov.hmrc.$packageName$.util.SingletonDriver

trait Driver extends ScalaDsl with EN with Matchers {

  implicit val driver: WebDriver = SingletonDriver.getInstance()

}