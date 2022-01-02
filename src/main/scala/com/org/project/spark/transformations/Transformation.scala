package com.org.project.spark.transformations

import org.apache.spark.sql.DataFrame

trait Transformation {
  def transform(df : DataFrame) : DataFrame
}
