package wwc

final case class CommitFiles(breachEncapsulationOfValues: Set[CommitFile]) {
  val fileTypes: Set[FileType] = this.breachEncapsulationOfValues.map(_.fileType)
}
