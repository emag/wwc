package wwc

final case class Commit(committer: Committer, message: CommitMessage, date: CommitDate, changes: CommitFiles) {
  val fileTypes: Set[FileType] = changes.fileTypes
}
