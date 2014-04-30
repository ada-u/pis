import org.stairwaybooks.variance.{Person, ConvariantCell, NonvariantCell}

object Main extends App {

  val nc1 = new NonvariantCell[String]("Hi")

  // [Error] RigidCell is non-variant
  // val nc2: RigidCell[Any] = nc1

  val cc1 = new ConvariantCell[String]("Hi")
  val cc2: ConvariantCell[Any] = cc1

  def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y)
          x :: merge(xs1, ys)
        else
          y :: merge(xs, ys1)
    }

    val n = xs.length / 2
    if (n == 0)
      xs
    else {
      val (ys, zs) = xs splitAt n
      merge(orderedMergeSort(ys), orderedMergeSort(zs))
    }
  }

  val people = List(
    new Person("Larry", "Wall"),
    new Person("Anders", "Hejlsberg"),
    new Person("Guido", "van Rossum"),
    new Person("Alan", "Kay"),
    new Person("Yukihiro", "Matsumoto")
  )

  val sortedPeople = orderedMergeSort(people)
  println(people.mkString(" "))
  println(sortedPeople.mkString(" "))
}
