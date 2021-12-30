package com.org.project.jobs

import com.org.project.config.{DataUID, JobConfigLoader}
import com.org.project.core.ProjectApplication
import com.org.project.datarepository.{DataRepositoryInitializer, DataStoreRepository}
import com.org.project.spark.SparkSessions
import com.org.project.spark.pipeline.Pipeline
import com.org.project.spark.transformations.DropColumnTransformation

class CoreLoadJob() {
  print ("Core")
}

//object CoreLoadJob extends ProjectApplication with JobConfigLoader with SparkSessions{
object CoreLoadJob extends ProjectApplication with JobConfigLoader {
  println("Core load job loading config ")
  println(jobConfig)

//  println("Initialize the DataRepository")
  DataRepositoryInitializer(jobConfig, runDate , None)

  println("count =+=+= " + DataStoreRepository.count())
  println("test ")

//  println(DataStoreRepository.get(DataUID("curated" , "account_dim")).get )
//  println("Execute job")
  val NIL = scala.collection.immutable.Nil

  val enrichPipeline = Pipeline(
      new DropColumnTransformation("col1") ::
      new DropColumnTransformation("col2") ::
      NIL
  )

  val enrichedDf = enrichPipeline.execute(DataStoreRepository.get(DataUID("staging" , "account_dim")).get.read)
  println("finished read")
  println(enrichedDf.show())
  println("Done")
}

