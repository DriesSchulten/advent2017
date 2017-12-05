import scala.io.Source

object Day1 extends App {

  val input = Source.fromResource("Day1.txt").getLines().map {
    _.map(_.asDigit)
  }.toList

  val part1 = input.map { list ⇒
    list.foldLeft((0, list.last)) {
      case ((sum, prevElem), elem) if prevElem == elem ⇒ (sum + elem, elem)
      case ((sum, _), elem) ⇒ (sum, elem)
    }._1
  }

  part1.foreach(println)

  val part2 = input.map { list ⇒
    val (length, pivot) = (list.size, list.size / 2)
    def next(idx: Int): Int = (idx + pivot) % length

    list.indices.map(idx ⇒ if(list(idx) == list(next(idx))) list(idx) else 0).sum
  }

  part2.foreach(println)
}
