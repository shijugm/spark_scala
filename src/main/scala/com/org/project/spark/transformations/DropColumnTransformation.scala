package com.org.project.spark.transformations
import org.apache.spark.sql.DataFrame

class DropColumnTransformation(colList : String*) extends Transformation {
  // the colList can be a list of string ????
  override def transform(df: DataFrame): DataFrame = df.drop(colList: _*)

}
