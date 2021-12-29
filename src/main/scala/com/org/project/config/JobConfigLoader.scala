package com.org.project.config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

trait JobConfigLoader {
  val t = "In trait"
  val argumentList: Option[Array[String]]= None

  val configInputStream = getClass.getClassLoader.getResourceAsStream("core-load-job.conf")
  val configString = scala.io.Source.fromInputStream(configInputStream).mkString

  val jobConfig = ConfigSource.string(configString)
    .at("job-config")
    .loadOrThrow[JobConfig]
}

