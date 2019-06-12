package $packageName$.utils

case class Environment(environment: String) {

  val url: String = environment match {
    case "local" => "https://"
    case "dev" => ""
    case "development" | "qa" | "staging" => ""
    case _ => throw new IllegalArgumentException(s"##########  Environment: \$environment not known  ##########")
  }
}