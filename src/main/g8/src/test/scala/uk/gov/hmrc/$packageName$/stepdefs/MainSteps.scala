package uk.gov.hmrc.$packageName$.stepdefs

import uk.gov.hmrc.$packageName$.pages.GoogleHomePage

class MainSteps extends Steps {

  When("""^I navigate to the Google homepage\$""") { () =>
    GoogleHomePage.navigateToGoogle()

  }
}
