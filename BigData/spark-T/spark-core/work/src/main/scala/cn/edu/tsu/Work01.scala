package cn.edu.tsu

import org.apache.spark.{SparkConf, SparkContext}

object Work01 {
  def main(args: Array[String]): Unit = {
    //声明配置
    val sparkConf = new SparkConf().setAppName("wordCount").setMaster("local[*]")
    // 创建sparkContext
    val sc =new SparkContext(sparkConf)
    //业务逻辑
    val bigData=sc.textFile("F:/code/GitHub/Learning/BigData/spark-T/spark-core/work/src/main/resources/1_bigdata.txt")
    val math=sc.textFile("F:/code/GitHub/Learning/BigData/spark-T/spark-core/work/src/main/resources/1_math.txt")
    val res_data=bigData.map{x=> val line=x.split("\t");(line(0),line(1),line(2).toInt)}
    var res_math=math.map{x=> val line=x.split("\t");(line(0),line(1),line(2).toInt)}

    // 大数据课程成绩最好的前三名信息
    var res2=res_data.sortBy(x=>x._3,ascending = false)
    res2.take(3).foreach(println)

    // 每个学生的总成绩
    val all_score=res_data union res_math
    val score=all_score.map(x=>(x._1,x._3)).reduceByKey((a,b)=>a+b)
    score.foreach(println)

    // 按照学生总成绩排名，并把排名后结果存储为文本文件
    score.repartition(1).saveAsTextFile("F:/code/GitHub/Learning/BigData/spark-T/spark-core/work/src/main/resources/score.txt")


  }





}
