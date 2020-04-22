package cn.edu.tsu.spark

import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

/**
 * @author Gregorio
 * @date 2020/4/8 15:23
 */
case class Score1(kemu:String, name:String, score:Int)
object SqlSelect {
  def main(args: Array[String]): Unit = {
    val spark =SparkSession.builder().master("local[*]").appName("sql").getOrCreate()
    val data=spark.sparkContext.textFile("hdfs://master:9000/data/score.txt").filter(f=>f.trim!="").map(_.split(" "))
    val s=data.map(p=>Row(p(0),p(1),p(2).trim.toInt))
    val schema=StructType(StructField("kemu",StringType,true)::StructField("name",StringType,true)::StructField("score",IntegerType,true)::Nil)
    val df = spark.createDataFrame(s,schema)

    select2(df,spark)

  }

  def select1(df:DataFrame,spark:SparkSession): Unit ={
    df.createOrReplaceTempView("score")
    val frame = spark.sql("select * from score where score>80")
    frame.show()
  }

  def select2(df:DataFrame,spark:SparkSession): Unit ={
    val value = df.where("kemu='math' and score<90 and score>70")
    value.show()
  }



}
