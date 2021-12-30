package com.org.project.datarepository

import com.org.project.spark.SparkSessions
import org.apache.spark.sql.{DataFrame, SaveMode}

class ParquetDataStore(
                      val storePath : String,
                      val selectColumns : List[String]
                      )
extends DataStore with SparkSessions{

  override def read: DataFrame = spark.read.format("parquet").load(storePath)

  override def write(dataFrame : DataFrame) : Unit = {
    dataFrame.write.format("parquet").mode(SaveMode.Overwrite).save(storePath)
  }

}
