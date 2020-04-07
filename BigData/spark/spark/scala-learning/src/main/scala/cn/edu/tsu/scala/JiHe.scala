package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 11:27
 */
object JiHe extends App {
  // List定义方式
  val fruit:List[String]=List("apple","pears","oranges")
  val fruit2:List[String]="a"::"p"::"o"::Nil

  println(fruit.head)//apple
  println(fruit.init)//List(apple, pears)去尾
  println(fruit.last)//oranges
  println(fruit.tail)//List(pears, oranges)去头
  println(fruit:::fruit2)//List(apple, pears, oranges, a, p, o)添加元素到列表
  println(fruit.take(2))//List(apple, pears)获取前n个元素
  println(fruit.contains("apple"))//true

  //Set
  val set:Set[Int]=Set(1,2,3,4,5)

  // Map
  val map:Map[String,Int]=Map("John"->21,"Tom"->22)

  //元组
  val t=(1,2,3,"ll")
  val tuple2=Tuple4(1,3,4,5)//后面的数字表示容量


}
