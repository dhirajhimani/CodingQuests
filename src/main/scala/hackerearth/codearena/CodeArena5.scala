package hackerearth.codearena

object CodeArena5 extends App {

  var N = scala.io.StdIn.readLine().trim.toInt

  for (i <- 1 to N ) {
    val k_h = scala.io.StdIn.readLine().trim.split(" ").map(_.toInt)

    val nodes = countNodes(k_h(0), k_h(1))
    println(nodes)
    println(calculateMod(nodes))
    println(nodes.toString.split("").map(_.toInt).sum)
  }

  def countNodes(k: Int, h: Int): Int = {
    (Math.pow(k, h+1) - 1).toInt / (k-1)
  }

  def calculateMod(nodes: Int): Int = {
    val mod = nodes % 10
    val rem = nodes/10

    if(rem == 0) {
      mod
    } else {
      mod + calculateMod(rem)
    }
  }

}
