package uk.gov.hmrc.$packageName$.stepdefs

import uk.gov.hmrc.$packageName$.pages.{Driver, GoogleHomePage}

class MainSteps extends Driver {

  When("""^I navigate to the Google homepage\$""") { () =>
    GoogleHomePage.navigateToGoogle()

  }
}
