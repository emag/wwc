package wwc

final case class CommitFile(name: String) {
  private val fileExtensionsRegex = """.*\.(\w+)""".r

  val fileType: FileType = this.name match {
    case fileExtensionsRegex(ext) =>
      ext match {
        case "scala" | "sbt" => Scala
        case "java"          => Java
        case "js"            => JavaScript
        case "ts"            => TypeScript
        case "html" | "htm"  => HTML
        case "jsx" | "tsx"   => JSX
        case "sql"           => SQL
        case "dig"           => Digdag
        case "json"          => JSON
        case "yaml" | "yml"  => YAML
        case "xml"           => XML
        case "tf"            => Terraform
        case "conf"          => Config
        case "md"            => Markdown
        case _               => Other
      }
    case _ => Other
  }
}
