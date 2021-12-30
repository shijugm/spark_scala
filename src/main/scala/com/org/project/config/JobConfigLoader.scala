package com.org.project.config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

import java.time.LocalDate

trait JobConfigLoader {

  val argumentList: Option[Array[String]]= None

  val configInputStream = getClass.getClassLoader.getResourceAsStream("core-load-job.conf")
  val configString = scala.io.Source.fromInputStream(configInputStream).mkString

  val jobConfig = ConfigSource.string(configString)
    .at("job-config")
    .loadOrThrow[JobConfig]

  // Temporarily added until the commandline parser is implemented
  val runDate = LocalDate.now.minusDays(1)
}

