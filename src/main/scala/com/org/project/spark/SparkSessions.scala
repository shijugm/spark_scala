package com.org.project.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf

trait SparkSessions {
  val sparkOptions : Map[String, String] = Map.empty

  val appName : Option[String] = None

  private val defaultConfiguration = SparkDefaultConfigurationLoader.Spark.settings

  lazy private val sparkConfig = new SparkConf(true)
    .setAppName(appName.getOrElse(SparkDefaultConfigurationLoader.appName))
    .setAll(defaultConfiguration ++ sparkOptions)

  lazy val sparkSessionBuilder = SparkSession.builder().config(sparkConfig)

  lazy val spark = sparkSessionBuilder.enableHiveSupport().getOrCreate()


}
