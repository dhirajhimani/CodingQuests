package hackerrank

object AndThenExample extends App {
//  andThen is just function composition. Given a function f

  val f: String => Int = s => s.length
//  andThen creates a new function which applies f followed by the argument function

  val g: Int => Int = i => i * 2

  val h = f.andThen(g)
//  h(x) is then g(f(x))
  println(h("Dhiraj"))// f = | Dhiraj => Dhiraj.length | = 6, g | 6 => 6 * 2 | = 12
}
