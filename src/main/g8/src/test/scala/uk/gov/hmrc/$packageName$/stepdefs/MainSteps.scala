package uk.gov.hmrc.$packageName$.stepdefs

import uk.gov.hmrc.cucumber.pages.GovUkPage
import uk.gov.hmrc.cucumber.util.Driver

class MainSteps extends Driver {

  When("""^I navigate to the GovUk homepage$""") { () =>
    GovUkPage.navigateTo()

  }
}