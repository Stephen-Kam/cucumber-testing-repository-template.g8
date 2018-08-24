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

  //Edit the VM properties with the following: -Denvironment={dev/qa/staging} to select your environment
  val host = {
    environment match {
      case Environment.Local   ⇒ "https:"
      case Environment.Dev     ⇒ "https:"
      case Environment.Qa      ⇒ "https:"
      case Environment.Staging ⇒ "https:"
      case _                   ⇒ throw new IllegalArgumentException(s"Environment '\$environment' not known")
    }
  }
}

