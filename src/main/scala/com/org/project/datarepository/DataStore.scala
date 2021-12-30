package com.org.project.datarepository

import org.apache.spark.sql.DataFrame

trait DataStore {
  /*
  This method is the read for a Datastore. it returns a dataframe
   */
  def read: DataFrame

  /*
  Override this method for writing to a datastore
   */
  def write(dataFrame: DataFrame):Unit
}
