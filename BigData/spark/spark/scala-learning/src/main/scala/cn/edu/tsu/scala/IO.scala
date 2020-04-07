package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 12:39
 */
object IO {
  def main(args: Array[String]): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("F:/code/GitHub/Learning/BigData/spark/spark/scala-learning/src/main/resources/info.txt"))
    pw.write("Hello Scala IO")
    pw.close()

    import scala.io.Source
    val file:Source=Source.fromFile("F:/code/GitHub/Learning/BigData/spark/spark/scala-learning/src/main/resources/info.txt")
    file.foreach{print}
    file.close()
  }
}
