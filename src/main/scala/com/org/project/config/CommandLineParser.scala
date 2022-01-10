package com.org.project.config

import java.time.format.DateTimeFormatter
import scopt.OptionParser
import scopt.Read
import scopt.Read.reads
import java.time.LocalDate

//import scala.util.{Try, Success, Failure}

case class CommandLineOptions(runDate: LocalDate = LocalDate.now.minusDays(1),
                              configFile: Option[String] = None,
                              scenarioID: Option[String] = None
                             )


class CommandLineParser extends OptionParser[CommandLineOptions]("projectName") {
  override def showUsageOnError: Boolean = true

  implicit  val LocalDateSupport : Read[LocalDate] = reads {timestamp =>
    LocalDate.parse(timestamp, DateTimeFormatter.ofPattern("yyyy/MM/dd"))

//    To add checks for the timestamp parameter
//    tryParseLocalDate(timestamp) match {
//      case Success(localDate) => localDate
//      case Failure(e) => throw new IllegalArgumentException("The date argument cannot be parsed")
//    }
  }

// To add checks for the timestamp parameter
//  def tryParseLocalDate(timestamp: String): Try[LocalDate] = {
//    Try {
//      LocalDate.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE)
//    } recover {
//      case _ =>
//        LocalDate.parse(timestamp, DateTimeFormatter.ofPattern("yyyy/MM/dd"))
//    }
//  }

  opt[String]('s' , "scenario-id")
    .required()
    .action((scenario, projectConfiguration) => projectConfiguration.copy(scenarioID = Some(scenario)))
    .text("ScenarioId for the job is required")

  opt[String]('f' , "config-file")
    .required()
    .action((configPath, projectConfiguration) => projectConfiguration.copy(configFile = Some(configPath)))
    .text("Config file path of the job")

  opt[LocalDate]('d' , "run-date")
    .required()
    .action((localDate, projectConfiguration) => projectConfiguration.copy(runDate = localDate))
    .text("Run Date for the job in yyyy/mm/dd format")

  def parse(args: Seq[String]): Option[CommandLineOptions] = super.parse(args = args, CommandLineOptions())

}