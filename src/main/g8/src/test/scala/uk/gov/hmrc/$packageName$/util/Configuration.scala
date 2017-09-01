package uk.gov.hmrc.$packageName$.util

object Environment extends Enumeration {
  type Name = Value
  val Local, Dev, Qa, Staging = Value
}

object Configuration {

  lazy val environment: Environment.Name = {
    val environmentProperty = Option(System.getProperty("environment")).getOrElse("local").toLowerCase
    environmentProperty match {
      case "local"   ⇒ Environment.Local
      case "qa"      ⇒ Environment.Qa
      case "dev"     ⇒ Environment.Dev
      case "staging" ⇒ Environment.Staging
      case _         ⇒ throw new IllegalArgumentException(s"Environment '\$environmentProperty' not known")
    }
  }

  val (host, authHost) = {
    environment match {
      case Environment.Local   ⇒ ("http://localhost:7000", "http://localhost:9949")

      case Environment.Dev     ⇒ ("https://www-dev.tax.service.gov.uk", "https://www-dev.tax.service.gov.uk")

      case Environment.Qa      ⇒ ("https://www-qa.tax.service.gov.uk", "https://www-qa.tax.service.gov.uk")

      case Environment.Staging ⇒ ("https://www-staging.tax.service.gov.uk", "https://www-staging.tax.service.gov.uk")

      case _                   ⇒ throw new IllegalArgumentException(s"Environment '\$environment' not known")
    }
  }
}

