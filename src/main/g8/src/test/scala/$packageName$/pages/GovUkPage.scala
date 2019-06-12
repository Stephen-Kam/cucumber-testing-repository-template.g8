package $packageName$.pages

import $packageName$.pages.generic.BasePage

object GovUkPage extends WebPage {

  url = "/www.gov.uk"

  override val header = Some(gm("govuk.header"))

}
