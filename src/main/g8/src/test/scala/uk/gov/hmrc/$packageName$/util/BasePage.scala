package uk.gov.hmrc.$packageName$.util

import java.io.IOException
import java.net.URI
import java.util

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

trait BasePage
  extends ScalaDsl
    with Matchers
    with ImplicitWebDriverSugar
    with NavigationSugar
    with EN {


}
