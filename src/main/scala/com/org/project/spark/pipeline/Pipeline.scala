package com.org.project.spark.pipeline

import com.org.project.spark.SparkSessions
import com.org.project.spark.transformations.Transformation
import org.apache.spark.sql.DataFrame

class Pipeline(pipelineSteps: List[Transformation]) extends SparkSessions {
  def execute(dataframe: DataFrame) : DataFrame = {
    pipelineSteps.foldLeft(dataframe)((s,f) => f.transform(s))
  }
}

object Pipeline extends SparkSessions {
  def apply(pipelineSteps: List[Transformation]) : Pipeline = new Pipeline(pipelineSteps)
}