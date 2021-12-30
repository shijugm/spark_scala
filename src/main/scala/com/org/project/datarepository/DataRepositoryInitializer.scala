package com.org.project.datarepository

import com.org.project.config.{CSVDataStoreConfig, DataUID, JobConfig, ParquetDataStoreConfig}
import com.org.project.datarepository.DataStoreRepository

import java.time.LocalDate

object DataRepositoryInitializer {
  def apply(jobConfig: JobConfig, runDate: LocalDate, scenarioId: Option[String]): Unit = {

    println("data repository initializer called")
    DataStoreRepository.add(
      jobConfig.dataRepositoryConfig.dataStoreConfigs
        .map( {
              case pConfig: ParquetDataStoreConfig =>
                pConfig.dataUID -> new ParquetDataStore(pConfig.path,
                                                        pConfig.selectColumns.getOrElse(List.empty)
                                                        )
              case pConfig : CSVDataStoreConfig =>
                pConfig.dataUID -> new CSVDataStore(pConfig.path,
                  pConfig.selectColumns.getOrElse(List.empty)
                )
              }
            ).toMap
    )



  }


}
