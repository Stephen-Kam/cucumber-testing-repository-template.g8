package uk.gov.hmrc.$packageName$.stepdefs

import uk.gov.hmrc.$packageName$.pages.{Driver, GovUkPage}

class MainSteps extends Driver {

  When("""^I navigate to the GovUk homepage\$""") { () =>
    GovUkPage.navigateTo()

  }
}
