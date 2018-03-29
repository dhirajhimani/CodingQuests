package hackerrank.functionalprogramming

import scala.collection.mutable.ListBuffer
import hackerrank.functionalprogramming.FunctionalHelpers._

object FractalTrees_1 extends App {

  import FractalTrees._

  printFractalTrees(2, 16)
}

object FractalTrees {
  case class Point(x: Int, y: Int)
  case class Branch(begin: Point, end: Point, size:Int)
  type Board = Array[Array[Char]]
  type Branches = Seq[Branch]
  type Points = Seq[Point]

  def printFractalTrees(iterations: Int, size: Int): Unit = {
    (
      get(aBasicPoint)              andThen
      splitBranch(iterations, size) andThen
      extractPointsFromBranches     andThen
      paintPointsOnBoard(newBoard)  andThen
      printBoard)()
  }


  private def aBasicPoint: Point = {
    Point(x=63, y=50)
  }

  private def aBasicBranch: Branch = {
    Branch(Point(x=63, y=50), Point(x=48, y=50), size = 16)
  }

  private def newBoard: Board = Array.fill(64)(Array.fill(100)('_'))

  private def splitBranch(N:Int, size:Int): Point => Branches = { startingPoint =>
    val branchesAndPoints =  splitBranchToThreeSmallerBranches(size, startingPoint)
    if (N ==0) {
      branchesAndPoints._1
    } else {
      branchesAndPoints._1 ++ splitBranch(N-1, size/2)(branchesAndPoints._2(0)) ++ splitBranch(N-1, size/2)(branchesAndPoints._2(1))
    }
  }

  private def getEndPointFromBranch(branch: Branch): Point = Point(branch.end.x, branch.end.y)

  private def splitBranchToThreeSmallerBranches(size: Int, p: Point): (Branches, Points) = {

    val branches = Seq(
    Branch(Point(p.x, p.y), Point(p.x - size, p.y), size),
    Branch(Point(p.x - size, p.y), Point(p.x - 2 * size, p.y + size), size),
    Branch(Point(p.x - size, p.y), Point(p.x - 2 * size, p.y - size), size))
    val points = Seq(
      getEndPointFromBranch(branches(1)),
      getEndPointFromBranch(branches(2))
    )
    (branches,points)
  }

  private def extractPointsFromBranches: Branches => Points =  _ flatMap getColoredPointsFromABranch

  private def getColoredPointsFromABranch(branch: Branch): Points = {
    var counter = if (branch.begin.y > branch.end.y) -1 else 1
    if (branch.begin.y == branch.end.y) {
      for {
        x <- (branch.end.x) to (branch.begin.x)
      } yield Point(x, branch.begin.y)
    } else {
      val points = new ListBuffer[Point]()
      for (i <- 1 to branch.size) {
        points += Point(branch.begin.x - i, branch.begin.y - i * counter)
      }
      points
    }
  }

  private def paintPointsOnBoard(board: Board) : Points => Board = { points: Points  =>
    points.foldLeft(board.clone()) { (mutatedBoard: Board, point: Point) =>
      mutatedBoard(point.x).update(point.y, '1')
      mutatedBoard
    }
  }

  private def printBoard: Board => Unit = { board => for(row <- board) println(row.mkString) }

}


