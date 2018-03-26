package hackerrank.graphtheory

//  https://www.hackerrank.com/challenges/torque-and-development/problem

object RoadsAndLibraries extends App {

  override def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var q = sc.nextInt();
    var a0 = 0;
    while(a0 < q){
      var n = sc.nextInt();
      var m = sc.nextInt();
      var c_lib = sc.nextInt();
      var c_road = sc.nextInt();
      var cities = Array.ofDim[Int](m,2);
      for(cities_i <- 0 to m-1) {
        for(cities_j <- 0 to 2-1){
          cities(cities_i)(cities_j) = sc.nextInt();
        }
      }
      val result = roadsAndLibraries(c_lib, c_road, cities);
      println(result)
      a0+=1;
    }
  }

//TODO See the java solution
  def roadsAndLibraries(c_lib: Int, c_road: Int, cities: Array[Array[Int]]): Int =  {
    0
    // WIP
  }

}
