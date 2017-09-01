package uk.gov.hmrc.$packageName$.runner

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
features = Array("src/test/resources/features"),
glue = Array("uk.gov.hmrc.$packageName$.stepdefs"),
format = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json"),
tags = Array("~@Ignore")
)
class ExampleRunner {

}
