package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)

  val unionSet = union(s1,s2)

  println(contains(unionSet, 1))
  println(contains(unionSet, 2))
  println(contains(unionSet, 3))

  println(contains(intersect(unionSet,s1),1))
  println(contains(intersect(unionSet,s2),1))

}
