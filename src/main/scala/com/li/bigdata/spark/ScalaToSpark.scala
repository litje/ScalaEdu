package com.li.bigdata.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
 * 使用Scala、Java 写 Spark的WordCount程序
 * 1、普通项目 转成 Maven项目：项目右键Add Frameworks Support 选择Maven，修改POM 引入Spark2.3.4
 * 2、
 */
object ScalaToSpark {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("wordcount")
    conf.setMaster("local") // 本地运行
    conf.set("spark.testing.memory","2147480000")

    // 单词统计
    val sc = new SparkContext(conf)
    val fileSpark = sc.textFile("data/testdata.text") // 读取数据文件
    // 精简代码
//    fileSpark.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).foreach(println)
    // 获取每一行数据，根据 空格 拆分
    val words = fileSpark.flatMap((s:String) => {
      s.split(" ")
    })
    // 转换为 key value 形式
    val pairWord = words.map((x: String) => {
      new Tuple2(x, 1)
    })
    // 把相同key的 value加起来
    val res = pairWord.reduceByKey((x: Int, y: Int) => {
      x + y
    })
    res.foreach(println)
  }
}
