package uk.gov.hmrc.scubasteve.stepdefs

import uk.gov.hmrc.scubasteve.pages.GoogleHomePage

class MainSteps extends Steps {

  When("""^I navigate to the Google homepage$""") { () =>
    GoogleHomePage.navigateToGoogle()

  }
}
