package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 11:50
 */
class Point(xc:Int,yc:Int) {
  var x:Int=xc
  var y:Int=yc
  def move(dx:Int,dy:Int): Unit ={
    x=x+dx
    y=y+dy
    println("x的坐标为："+x)
    println("y的坐标为："+y)
  }
}
