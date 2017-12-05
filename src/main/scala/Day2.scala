import scala.io.Source

object Day2 extends App {

  val input = Source.fromResource("Day2.txt").getLines().map { line ⇒
    line.split("\\s").map(_.toInt)
  }.toList

  val part1 = input.foldLeft(0) {
    case (sum, line) ⇒ sum + (line.max - line.min)
  }
  println(part1)

  val part2 = input.foldLeft(0) {
    case (sum, line) ⇒
      sum +
        (for {
          i ← line
          j ← line if i != j && i % j == 0
        } yield i / j).head
  }
  println(part2)
}
