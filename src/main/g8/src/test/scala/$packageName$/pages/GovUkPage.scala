package $packageName$.pages

import $packageName$.pages.generic.BasePage

object GovUkPage extends BasePage {

  val url = "/www.gov.uk"

  val header: String = gm("govuk.header")

}
