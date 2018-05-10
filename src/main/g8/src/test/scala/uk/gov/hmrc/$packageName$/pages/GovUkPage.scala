package uk.gov.hmrc.$packageName$.pages

import uk.gov.hmrc.$packageName$.pages.generic.WebPage
import uk.gov.hmrc.$packageName$.pages.generic.Driver

object GovUkPage extends WebPage {

  url = "/www.gov.uk"

  override val header = Some(gm("govuk.header"))

}
