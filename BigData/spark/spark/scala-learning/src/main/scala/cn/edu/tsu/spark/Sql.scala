package cn.edu.tsu.spark

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}


/**
 * @author Gregorio
 * @date 2020/4/7 17:19
 */
case class Score(kemu:String,name:String,score:Int)
object Sql  {


  def main(args: Array[String]): Unit = {
    val spark =SparkSession.builder().master("local[*]").appName("sql").getOrCreate()
    val score = spark.read.text("hdfs://master:9000/data/score.txt")
    program(spark)
  }

  def program(spark:SparkSession): Unit ={
    val data=spark.sparkContext.textFile("hdfs://master:9000/data/score.txt").filter(f=>f.trim!="").map(_.split(" "))
    val s=data.map(p=>Row(p(0),p(1),p(2).trim.toInt))
    val schema=StructType(StructField("kemu",StringType,true)::StructField("name",StringType,true)::StructField("score",IntegerType,true)::Nil)
    val df = spark.createDataFrame(s,schema)
    df.printSchema()
    df.show()
  }
  def reflectRdd(spark:SparkSession): Unit ={
    import spark.implicits._
    val data=spark.sparkContext.textFile("hdfs://master:9000/data/score.txt").filter(f=>f.trim!="").map(_.split(" "))
    val df = data.map(p=>Score1(p(0),p(1),p(2).trim.toInt)).toDF()
    df.printSchema()
    df.show()
  }

  def rddToDF(spark:SparkSession): Unit ={
    import spark.implicits._
    val mylist = List(("Tom",20),("Mary",28),("Eric",18),("Bob",31))
    val rdd = spark.sparkContext.parallelize(mylist)
    val frame = rdd.toDF("name", "age")
    frame.show()
  }
  def readJson(spark:SparkSession): Unit ={
    val jsonData=spark.read.json("hdfs://master:9000/data/testjson.json")
    jsonData.printSchema()
    jsonData.select("name").show()

  }
  def readCsv(spark:SparkSession): Unit ={
    val data = spark.read.option("header",value = false).option("step",",").
      csv("hdfs://master:9000/data/testcsv.csv")
    data.printSchema()
    data.show()
  }

  def readJdbc(spark:SparkSession): Unit ={
    val product =spark.read.format("jdbc").options(
      Map(
        "url"->"jdbc:mysql://localhost:3306/shop",
        "user"->"root",
        "password"->"123",
        "dbtable"->"product"
      )
    ).load()
    product.printSchema()
    product.show()
  }
}
