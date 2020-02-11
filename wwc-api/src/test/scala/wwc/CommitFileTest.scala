package wwc

import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class CommitFileTest extends AnyFlatSpec with Diagrams {
  behavior of "fileExtension"

  it should "map extension from file name" in {
    assert(CommitFile("Foo.scala").fileType === Scala)
  }
}
