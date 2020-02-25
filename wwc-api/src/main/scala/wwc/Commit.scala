package wwc

import scala.util.matching.Regex

final case class Commit(
    committer: Committer,
    message: CommitMessage,
    date: CommitDate,
    changes: CommitFiles
) {
  private val relatedTicketPattern: Regex = "[a-zA-Z]*#\\d+".r

  val fileTypes: Set[FileType] = changes.fileTypes

  val relatedTicket: Option[RelatedTicket] =
    relatedTicketPattern.findFirstMatchIn(message.value).map(hit => RelatedTicket(hit.matched))
}
