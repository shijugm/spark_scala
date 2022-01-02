package com.org.project.spark

import com.typesafe.config.{ConfigFactory, ConfigRenderOptions}
//
//import scala.collection.convert.ImplicitConversions.`set asScala`
//import scala.jdk.CollectionConverters._
import scala.collection.JavaConverters._

object SparkDefaultConfigurationLoader {
  println("inside Sparkdefaultconfigloader")
  private lazy val defaultConfig = ConfigFactory.load("spark-default.conf")

  private val config = ConfigFactory.load().withFallback(defaultConfig)

  /*
  Validate the loaded config by checking if there is the key for project
   */
  config.checkValid(ConfigFactory.defaultReference(), "project")

  print("config = ")
  println(config)

  private lazy val root = config.getConfig("project")

  lazy val appName = root.getString("app-name")

  println("appname = " + appName)

  //  This object parses the sparkconig from the conf file and converts it to a MAP
  object Spark {

    private val spark = root.getConfig("spark")
    println("spark = " + spark)

    private val settingsObj = spark.getConfig("configuration")
    println("settingsObj = " + settingsObj)

    lazy val settings = settingsObj.entrySet().asScala.map(entry => (entry.getKey, entry.getValue.toString)
    ).toMap

  }
}
