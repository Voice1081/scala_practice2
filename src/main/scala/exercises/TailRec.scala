package exercises

import scala.annotation.tailrec


object TailRec {

  //  На вход дан список чисел
  //  числа последовательно складываются
  //  необходимо найти число, которое первый раз повторно встречается в рез-те суммирования
  //  если список кончается, а число не найдено, в конец списка дописываем исходный список и продолжаем вычисления
  //  рез-том функции должно первое число, которое встречается дваджы впервые
  //  нпр дан список List(1, -1)
  //  первым значением, встретившимся дважды будет 0
  //  1 + (-1) | 0
  //  0 + 1    | 1
  //  1 + (-1) | 0

  //  должна быть использована аннотация @tailrec
  //  while и var запрещены
  //  подумайте об исключениях
  //  try catch не использовать
  //  2 балла

  def secondOccurrence(inp: List[Int]): Option[Int] = {
    @tailrec
    def f(inp: List[Int], s: Set[Int], pos: Int, sum: Int): Option[Int] ={
      if(s.contains(sum + inp(pos % inp.length))) Option(sum + inp(pos % inp.length))
      else f(inp, s.union(Set(sum + inp(pos % inp.length))), pos + 1, sum + inp(pos % inp.length))
    }
    if(!inp.exists(_ >= 0) || !inp.exists(_ <= 0) || inp.isEmpty) None
    else f(inp, Set(), 0, 0)
  }


  def main(args: Array[String]): Unit = {
    //val l = List(7, 7, -2, -7, -4)
    //secondOccurrence(l) == 14

  }

}