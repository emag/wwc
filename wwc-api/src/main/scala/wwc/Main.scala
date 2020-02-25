package wwc

import java.io.File
import java.time.{ZoneId, ZonedDateTime}

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.revwalk.filter.RevFilter
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.treewalk.TreeWalk
import org.eclipse.jgit.treewalk.filter.TreeFilter

import scala.jdk.CollectionConverters._

object Main extends App {
  val gitDir = new File(s"${args(0)}/.git")

  val repository = new FileRepositoryBuilder()
    .setGitDir(gitDir)
    .readEnvironment()
    .findGitDir()
    .build()
  val git        = new Git(repository)
  val gitCommits = git.log().setRevFilter(RevFilter.NO_MERGES).call()

  val commits = gitCommits.asScala
    .map(commit => {
      val committer = Committer(
        name = commit.getAuthorIdent.getName,
        email = commit.getAuthorIdent.getEmailAddress
      )

      val commitDate =
        CommitDate(ZonedDateTime.ofInstant(commit.getAuthorIdent.getWhen.toInstant, ZoneId.of("Asia/Tokyo")))
      val commitMessage = CommitMessage(commit.getFullMessage)

      val tree     = commit.getTree
      val treeWalk = new TreeWalk(repository)
      treeWalk.addTree(tree)
      treeWalk.setRecursive(true)

      commit.getParents.foreach(p => treeWalk.addTree(p.getTree))
      treeWalk.setFilter(TreeFilter.ANY_DIFF)
      val commitFiles = scala.collection.mutable.Set[CommitFile]()
      while (treeWalk.next()) {
        commitFiles.add(CommitFile(treeWalk.getPathString))
      }

      Commit(
        committer = committer,
        message = commitMessage,
        date = commitDate,
        changes = CommitFiles(commitFiles.toSet)
      )
    })
    .toSet

  val json = JsonEncoder.encode(Commits(commits))

  val wd = os.home / "Downloads"
  os.write.over(wd / "wwc.json", json.toString())
}
