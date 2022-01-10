package com.org.project.config

import com.typesafe.config.ConfigFactory
import pureconfig.ConfigSource
import com.org.project.config.{CommandLineParser  =>cmparser}
import pureconfig.generic.auto._

import java.time.LocalDate

trait JobConfigLoader {
  val argumentList: Option[Array[String]]= None
//
  lazy val commandLineOptions = {
    val commandLineParser = new CommandLineParser
    commandLineParser.parse(argumentList.getOrElse(Array.empty)) match {
      case Some(configFile) => configFile
      case _ => throw new Exception("Error parsing command line arguments")
    }
  }


  lazy val configFilePath = commandLineOptions.configFile.get

  lazy val configInputStream = getClass.getClassLoader.getResourceAsStream(configFilePath)
  lazy val configString = scala.io.Source.fromInputStream(configInputStream).mkString

  lazy val jobConfig = ConfigSource.systemProperties.withFallback(ConfigSource.string(configString))
    .at("job-config")
    .loadOrThrow[JobConfig]


  // Temporarily added until the commandline parser is implemented
  val runDate = LocalDate.now.minusDays(1)
}

