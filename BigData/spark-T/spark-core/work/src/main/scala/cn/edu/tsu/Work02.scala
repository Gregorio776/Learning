package cn.edu.tsu

import org.apache.spark.sql.SparkSession


case class User(userId:Int,gender:String,age:Int,occupation:Int,zip:String)
object Work02{
  def main(args: Array[String]): Unit = {
    val spark =SparkSession.builder().master("local[*]").appName("sql").getOrCreate()

    val users=spark.sparkContext.textFile("F:/code/GitHub/Learning/BigData/spark-T/spark-core/work/src/main/resources/users.dat").map(_.split("::"))
    import spark.implicits._
    val user=users.map(x=>User(x(0).trim.toInt,x(1),x(2).trim.toInt,x(3).trim.toInt,x(4))).toDF()

    // (1)	统计年龄在18岁及以上的用户数量
    val count_1=user.filter("age>18").count()
    println("--------------年龄在18岁及以上的用户数量----------------------"+count_1)


    // (2)	统计女性和男性分别有多少人
    val count_F=user.filter("gender='F'").count()
    val count_M=user.filter("gender='M'").count()
    println("-------------------男性人数---------------------------------"+count_F)
    println("-------------------女性人数---------------------------------"+count_M)


    // (3)	把数据中男性使用1代替，女性使用0代替，并按照年龄排序，显示前5人数据
    spark.udf.register("replace",(x:String)=>{
      x match {
        case "F"=>0
        case "M"=>1
      }
    })
    val res=user.selectExpr("userId","replace(gender) as sex","age","occupation","zip")
    res.show(5)


  }


}
