package uk.gov.hmrc.$packageName$.pages

import uk.gov.hmrc.$packageName$.pages.generic.WebPage

object GovUkPage extends WebPage {

  url = "/www.gov.uk"

  val header: String = gm("govuk.header")

}
