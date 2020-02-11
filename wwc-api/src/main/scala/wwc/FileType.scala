package wwc

sealed trait FileType

object Scala      extends FileType
object Java       extends FileType
object JavaScript extends FileType
object TypeScript extends FileType
object HTML       extends FileType
object JSX        extends FileType
object SQL        extends FileType
object Digdag     extends FileType
object JSON       extends FileType
object YAML       extends FileType
object XML        extends FileType
object Terraform  extends FileType
object Config     extends FileType
object Markdown   extends FileType
object Other      extends FileType
