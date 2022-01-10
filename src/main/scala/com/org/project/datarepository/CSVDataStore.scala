package com.org.project.datarepository

import com.org.project.spark.SparkSessions
import org.apache.spark.sql.{DataFrame, SaveMode}

class CSVDataStore(
                      val storePath : String,
                      val selectColumns : List[String]
                      )
extends DataStore with SparkSessions{
  println(s"reading file from $storePath")
  override def read: DataFrame = spark.read.format("csv").option("header", "true").load(storePath)

  override def write(dataFrame : DataFrame) : Unit = {
    dataFrame.write.format("csv").mode(SaveMode.Overwrite).save(storePath)

  }
}
