import scala.io.Source

object Main extends App {
  val input = args(0)
  val filename = "input.txt"
  val words = Source.fromFile(filename).getLines.flatMap(line => line.split("\\W+")).toSeq
  val lines = Source.fromFile(filename).getLines.toSeq

  input match {
    case "--words" =>
      println(words
        .groupBy(identity)
        .map(t => (t._1, t._2.length)))
    case "--lines" =>
      println(lines
        .map(t => (t, t.length, t.split("\\s+").length, t.split("\\s+").toList)))
  }
}