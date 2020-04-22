package cn.edu.tsu.test

import org.apache.spark.sql.SparkSession

/**
 * @author Gregorio
 * @date 2020/4/21 11:00
 */
case class Movie(movieId:Int,title:String,Genres:String)
object test01 extends App{
  import spark.implicits._
  val spark =SparkSession.builder().master("local[*]").appName("sql").getOrCreate()
  val data = spark.sparkContext.textFile("F:/HASEE/Desktop/data/5/movies.dat").map(_.split("::"))
  val movie = data.map(m=>Movie(m(0).trim.toInt,m(1),m(2))).toDF()

}
