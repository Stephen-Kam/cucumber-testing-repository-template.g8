package uk.gov.hmrc.scubasteve.pages

import uk.gov.hmrc.scubasteve.stepdefs.Steps

object GoogleHomePage extends WebPage {

  def navigateToGoogle(): Unit = go to "https://www.google.co.uk"

}
