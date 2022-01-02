package com.org.project.jobs

import com.org.project.config.{DataUID, JobConfigLoader}
import com.org.project.core.ProjectApplication
import com.org.project.datarepository.{DataRepositoryInitializer, DataFrameRepositoryConfig}
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

  println("count =+=+= " + DataFrameRepositoryConfig.count())
  println("test ")

//  println("Execute job")

  // to be moved to a shared file. This is needed to set the pipeline as a collection.
  val NIL = scala.collection.immutable.Nil

  val enrichPipeline = Pipeline(
      new DropColumnTransformation("col1") ::
      // the below option also works because the transformation takes String*
      //new DropColumnTransformation( "col2","col4") ::
      NIL
  )

  val enrichedDf = enrichPipeline.execute(DataFrameRepositoryConfig.get(DataUID("staging" , "account_dim")).get.read)
  println("finished read")
  println(enrichedDf.show())

  DataFrameRepositoryConfig.get(DataUID("conformed" , "account_dim")).get.write(enrichedDf)

  println("Done")
}

