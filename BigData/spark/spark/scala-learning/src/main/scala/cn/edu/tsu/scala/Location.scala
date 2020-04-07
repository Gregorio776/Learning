package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 12:10
 */
class Location(val xc:Int,val yc:Int,val zc:Int) extends Point(xc,yc){
  var z: Int =zc

  def move(dx: Int, dy: Int,dz:Int): Unit = {
    x=x+dx
    y=y+dy
    z=z+dz
    println("x的坐标："+x)
    println("y的坐标："+y)
    println("z的坐标："+z)
  }
}
