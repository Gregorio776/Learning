package com.grq.spark

import org.apache.spark.{SparkConf, SparkContext}

object WordCount extends App {
  //声明配置
  val sparkConf = new SparkConf().setAppName("wordCount").setMaster("local[*]")
  // 创建sparkContext
  val sc =new SparkContext(sparkConf)
  //业务逻辑
  val lines =sc.textFile("hdfs://master:9000/data/score.txt")
  val counts = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
  val res = counts.collect()
  res.foreach(info=>print(info))
  println()
  //关闭spark连接
  sc.stop()


}


