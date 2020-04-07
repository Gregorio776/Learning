package cn.edu.tsu.spark

/**
 * @author Gregorio
 * @date 2020/4/7 16:26
 */
import cn.edu.tsu.spark.Test.getClass
import org.apache.spark.{SparkConf, SparkContext}

case class Person(name:String,age:Int)
object IO extends App {
  //声明配置
  val sparkConf = new SparkConf().setAppName("IO").setMaster("local[*]")
  // 创建sparkContext
  val sc =new SparkContext(sparkConf)
  val url=getClass.getResource("/data").getPath


  readJson()

  def readJson(): Unit ={
    // 读Json
    import org.json4s._
    import org.json4s.jackson.JsonMethods._
    val input=sc.textFile(url+"/testJson.json")
    implicit val formats: DefaultFormats.type = DefaultFormats
    val in_json=input.collect().map{x=>parse(x).extract[Person]}
    in_json.foreach(println)
  }
  def writeJson(): Unit ={
    // 存储Json

  }

}
