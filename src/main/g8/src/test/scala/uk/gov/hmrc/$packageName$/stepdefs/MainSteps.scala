package uk.gov.hmrc.$packageName$.stepdefs

import uk.gov.hmrc.$packageName$.util.BasePage

class MainSteps extends BasePage {

  When("""^I navigate to the Psa Lookup psaref page\$""") { () =>
    go to "https://www.google.co.uk"

  }
}
