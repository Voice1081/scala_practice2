package exercises

//  while, return и var запрещены
//  0.5 балла
object Currying {

  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    x => y => f(x, y)


  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (x, y) => f(x)(y)

}