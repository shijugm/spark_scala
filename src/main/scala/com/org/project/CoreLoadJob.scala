package com.org.project

import com.org.project.config.{JobConfig, JobConfigLoader}
import com.org.project.core.ProjectApplication
import com.org.project.spark.SparkSessions

class CoreLoadJob() {
  print ("Core")
}

object CoreLoadJob extends ProjectApplication with JobConfigLoader with SparkSessions{
  println("Core load job loading config ")
  println(jobConfig)

//  println("Initialize the DataRepository")

//  println("Execute job")

//  println("Done")
}

