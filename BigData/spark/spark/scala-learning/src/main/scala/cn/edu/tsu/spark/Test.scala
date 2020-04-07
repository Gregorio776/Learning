package cn.edu.tsu.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Gregorio
 * @date 2020/4/7 14:49
 */
object Test extends App {
  //声明配置
  val sparkConf = new SparkConf().setAppName("Test").setMaster("local[*]")
  // 创建sparkContext
  val sc =new SparkContext(sparkConf)
  val url=getClass.getResource("/data").getPath

  val bigData=sm(sc.textFile(url+"/result_bigdata.txt"))
  val math=sm(sc.textFile(url+"/result_math.txt"))

  val student=sc.textFile(url+"/student.txt")


  test04()


  def test04(): Unit ={
    // 计算每位学生的平均成绩
    var score=bigData.union(math).map(x=>(x._1,x._3))
    var cb_score=score.combineByKey(
      count=>(count,1),
      (acc:(Int,Int),count)=>(acc._1+count,acc._2+1),
      (acc1:(Int,Int),acc2:(Int,Int))=>(acc1._1+acc2._1,acc1._2+acc2._2)
    )
    var res=cb_score.map(x=>(x._1,x._2._1.toDouble/x._2._2))
    res.foreach(println)
  }

  def test03(): Unit ={
    // 学生的总成绩
    var all_source=bigData.union(math)
    var res=all_source.map(x=>(x._1,x._3)).reduceByKey(_+_)
    res.foreach(println)
  }

  // 获的成绩前五的学生信息
  def getHead(source:RDD[(String,String,Int)], num:Int)=
    source
      .sortBy(x=>x._3,ascending = false)
      .take(num)

  def test01()={
    // 获得单科成绩100的学生id
    val bigData_Id=bigData.filter(_._3==100).map(_._1)
    val math_id=math.filter(_._3==100).map(_._1)
    val id = bigData_Id.union(math_id).distinct
    id.foreach(println)
  }

  def test02(): Unit ={
    // 获的成绩前五的学生信息
    val res_bigData=getHead(bigData,5)
    val res_math=getHead(math,5)

    res_bigData.foreach(println)
    res_math.foreach(println)
  }

  // 转换成（String,String,Int）
  def sm(rdd:RDD[String]):RDD[(String,String,Int)]=rdd.map{x=>val line=x.split("\t");(line(0),line(1),line(2).toInt)}
}
