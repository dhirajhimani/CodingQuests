package hackerrank.algorithims.search

// https://www.hackerrank.com/challenges/icecream-parlor

object IceCreamParlor extends App {

//  icecreamParlor(4, Array(1,4,5,3,2)).foreach(println)
//  icecreamParlor(4, Array(5,4,3,2,1)).foreach(println)
//  icecreamParlor(101, Array(722, 600, 905, 54, 47)).foreach(println)
  icecreamParlor(35, Array(210, 582 ,622 ,337 ,626 ,580 ,994 ,299 ,386 ,274 ,591 ,921, 733, 851, 770, 300, 380, 225, 223, 861, 851, 525, 206, 714, 985, 82, 641, 270, 5, 777, 899, 820, 995, 397, 43, 973, 191, 885, 156, 9, 568, 256, 659, 673, 85, 26, 631, 293, 151, 143, 423)).foreach(println)

  def icecreamParlor(m: Int, arr: Array[Int]): Array[Int] = {
    icecreamParlor(m, arr.zipWithIndex)
  }

  def icecreamParlor(m: Int, flavor_price_index: Array[(Int, Int)]): Array[Int] = {
    val min_price_index = flavor_price_index.minBy(_._1)

    val filtered = flavor_price_index.filter(t => {
      t._2 != min_price_index._2 && (t._1 + min_price_index._1) == m
    })
    if (filtered.length < 1) {
      icecreamParlor(m, flavor_price_index.filter(_ != min_price_index))
    } else {
      Array(min_price_index._2 + 1, filtered(0)._2 + 1).sorted
    }
  }

}
