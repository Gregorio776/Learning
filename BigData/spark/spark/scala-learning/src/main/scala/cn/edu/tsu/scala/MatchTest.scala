package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 12:30
 */
object MatchTest {
  def m1(x:Int): Unit =x match {
    case 1 =>println("one")
    case 2 =>println("two")
    case _ =>println("many")
  }
  def m2(arr:List[Int]): Unit = arr match {
    case List(1,_,_)=>println("1")
    case List(1,_*)=>println(2)
    case List(_,1,_*)=>println(3)
    case List(_*)=>println("4")
  }
  def main(args: Array[String]): Unit = {

    m1(5)
    m2(List(2,2,1,2,3,4))
  }
}
