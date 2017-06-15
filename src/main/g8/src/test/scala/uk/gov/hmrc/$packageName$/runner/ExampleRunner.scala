package uk.gov.hmrc.$packageName$.runner

@RunWith(classOf[Cucumber])
@CucumberOptions(
features = Array("src/test/resources/features"),
glue = Array("uk.gov.hmrc.stepdefs"),
format = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json"),
tags = Array("@RunOnlyInDev")
)
class ExampleRunner {

}
