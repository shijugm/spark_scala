name := "ProjectName"
version := "0.1"

scalaVersion := "2.13.1"
val sparkVersion = "3.2.0"


//spark core libraries
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion


libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.17.1"