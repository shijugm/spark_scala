package com.org.project.config

//import com.org.project.config.DataUID

case class JobConfig(jobName : String,
                     dataRepositoryConfig: DataRepositoryConfig,
                     maxNumDays: Option[Int],
                     tableName: Option[String],
                     pathConformed: Option[String],
                     pathCurated: Option[String],
                     pathStaging: Option[String]
                    )

case class DataRepositoryConfig(dataStoreConfigs: List[DataStoreConfig])

sealed trait DataStoreConfig
case class ParquetDataStoreConfig (
                                  dataUID: DataUID,
                                  path : String,
                                  selectColumns: Option[List[String]]
                                  ) extends DataStoreConfig
case class CSVDataStoreConfig (
                                    dataUID: DataUID,
                                    path: String,
                                    selectColumns: Option[List[String]]
                                  ) extends DataStoreConfig