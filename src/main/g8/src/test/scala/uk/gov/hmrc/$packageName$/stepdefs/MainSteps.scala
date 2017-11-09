package uk.gov.hmrc.$packageName$.stepdefs

import uk.gov.hmrc.$packageName$.pages.GovUkPage
import uk.gov.hmrc.$packageName$.pages.generic.Driver

class MainSteps extends Driver {

  When("""^I navigate to the GovUk homepage\$""") { () =>
    GovUkPage.navigateTo()

  }
}