package uk.gov.hmrc.$packageName$.pages

import uk.gov.hmrc.$packageName$.stepdefs.Steps

object GoogleHomePage extends WebPage {

  def navigateToGoogle(): Unit = go to "https://www.google.co.uk"

}
