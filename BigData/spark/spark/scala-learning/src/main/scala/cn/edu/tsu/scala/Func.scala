package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 11:14
 */
object Func extends App {

  // 函数做参数
  def addInt(f:(Int,Int)=>Int,a:Int,b:Int)=f(a,b)
  println(addInt((a:Int,b:Int)=>a+b,12,13))

  // 函数做返回值
  def rectangle(length:Int)=(height:Int)=>(length+height)*2
  val func=rectangle(3)
  println(func(4))

  // 函数柯里化(?????意义是啥)
  def add(a:Int)(b:Int)(c:Int):Int=a+b+c
  // 等价
  def f(a:Int)=(b:Int)=>(c:Int)=>a+b+c
  println(add(1)(2)(3))
}
