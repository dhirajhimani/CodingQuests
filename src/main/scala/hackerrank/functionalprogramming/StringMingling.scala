package hackerrank.functionalprogramming

object StringMingling extends App {

  val line1 = scala.io.StdIn.readLine()
  val line2 = scala.io.StdIn.readLine()
  //  val line1 = "asdf"
  //  val line2 = "qwer"

//  println(line1)
//  println(line2)

//  val mingleString = line1.zip(line2).foldLeft("")((a,b) => {
//    a + b._1 + b._2
//  })
//
//  println(mingleString)
  println(mutate(line1.toList,line2.toList))

//  def mutate(p:List[Char], q:List[Char]): String = {
//    if (p.isEmpty && q.isEmpty) ""
//    else if (p.isEmpty) q mkString
//    else if (q.isEmpty) p mkString
//    else p.head.toString + q.head.toString + mutate(p.tail, q.tail)
//  }

  def mutate(p:List[Char], q:List[Char]): String = (p,q) match {
    case (a, Nil) => a mkString
    case (Nil, b) => b mkString
    case (Nil, Nil) => ""
    case (a, b) => a.head.toString + b.head.toString + mutate(a.tail, b.tail)
  }
}
