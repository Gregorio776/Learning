package cn.edu.tsu.spark

import org.apache.spark.sql.SparkSession


/**
 * @author Gregorio
 * @date 2020/4/7 17:19
 */
object Sql extends App { //声明配置
  val spark=SparkSession.builder().master("local[*]").appName("sql").getOrCreate()

  spark.stop()
}
