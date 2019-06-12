package $packageName$.stepdefs

import $packageName$.pages.GovUkPage
import $packageName$.stepdefs.generic.BaseSteps

class MainSteps extends BaseSteps {

  When("""^I navigate to the GovUk homepage\$""") { () =>
    GovUkPage.navigateTo()
  }

  Then("""^I will be on the GovUk homepage\$"""){ () =>
    GovUkPage.on()
  }
}