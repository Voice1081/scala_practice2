import scala.annotation.tailrec

def secondOccurrence(inp: List[Int]): Option[Int] = {
  @tailrec
  def f(inp: List[Int], s: Set[Int], pos: Int, sum: Int): Option[Int] ={
    if(s.contains(sum + inp(pos % inp.length))) Option(sum + inp(pos % inp.length))
    else f(inp, s.union(Set(sum + inp(pos % inp.length))), pos + 1, sum + inp(pos % inp.length))
  }
  if(!inp.exists(_ >= 0) || !inp.exists(_ <= 0)) None
  else f(inp, Set(), 0, 0)
}

val l1 =  List(-3, 1, 1, 1)
val l2 = List(-1, 1)
secondOccurrence(l1)
l1.length