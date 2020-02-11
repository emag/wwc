package wwc

import play.api.libs.json.{JsObject, Json}

object JsonEncoder {
  def encode(commits: Commits): JsObject = {
    val data = commits.breachEncapsulationOfValues.map { commit =>
      Json.obj(
        "committer" -> Json.obj(
          "name"  -> commit.committer.name,
          "email" -> commit.committer.email
        ),
        "message"    -> commit.message.value,
        "date"       -> commit.date.value,
        "files"      -> commit.changes.breachEncapsulationOfValues.map(_.name),
        "file_types" -> commit.fileTypes.map(fileTypeToString)
      )
    }
    Json.obj(
      "commits" -> data
    )
  }

  private def fileTypeToString(fileType: FileType): String = fileType match {
    case Scala      => "Scala"
    case Java       => "Java"
    case JavaScript => "JavaScript"
    case TypeScript => "TypeScript"
    case HTML       => "HTML"
    case JSX        => "JSX"
    case SQL        => "SQL"
    case Digdag     => "Digdag"
    case JSON       => "JSON"
    case YAML       => "YAML"
    case XML        => "XML"
    case Terraform  => "Terraform"
    case Config     => "Config"
    case Markdown   => "Markdown"
    case Other      => "Other"
  }
}
