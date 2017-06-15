package uk.gov.hmrc.$packageName$.util

import java.io.IOException
import java.net.URI
import java.util

trait BasePage
  extends ScalaDsl
    with Matchers
    with ImplicitWebDriverSugar
    with NavigationSugar
    with En {


}
