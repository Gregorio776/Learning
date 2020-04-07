package cn.edu.tsu.spark

/**
 * @author Gregorio
 * @date 2020/4/7 16:26
 */
import cn.edu.tsu.spark.Test.getClass
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._
case class Person(name:String,age:Int)
object IO extends App {
  //声明配置
  val sparkConf = new SparkConf().setAppName("IO").setMaster("local[*]")
  // 创建sparkContext
  val sc =new SparkContext(sparkConf)
  val url=getClass.getResource("/data").getPath


  var jsonData=readJson()
  writeJson(jsonData)
  def readJson() ={
    // 读Json
    val input=sc.textFile(url+"/testJson.json")
    implicit val formats: DefaultFormats.type = DefaultFormats
    val in_json=input.collect().map{x=>parse(x).extract[Person]}
    in_json
  }
  def writeJson(jsonData:Array[Person]): Unit ={
    // 存储Json
    import org.json4s.JsonDSL._
    val json=jsonData.map{x=>("name"->x.name) ~ ("age"->x.age)}
    val jsons= json.map{x=>compact(render(x))}
    jsons.foreach(println)
    sc.parallelize(jsons).repartition(1).saveAsTextFile("F:/code/GitHub/Learning/BigData/spark/spark/scala-learning/src/main/resources/copyJson")
  }

}
