package com.org.project.datarepository

import com.org.project.config.DataUID
import scala.collection.mutable

trait DataRepository[T] {

  private lazy val repository = mutable.Map.empty[DataUID, T]

  def apply(dataUID: DataUID) : Option[T] = this.get(dataUID)

  def get(dataUID : DataUID) : Option[T] = repository.get(dataUID)

  def add(addMap : Map[DataUID, T] ) : this.type = {
    this.repository ++= addMap
    this
  }

  def add(dataUID : DataUID, item : T) : this.type = this.add(Map(dataUID -> item))

  def contains (dataUID: DataUID) : Boolean  = this.repository.contains(dataUID)

  def remove(dataUID: DataUID) : Option[T] = this.repository.remove(dataUID)

  def count() : Int = this.repository.size

}
