name := "ProjectName"
version := "0.1"

scalaVersion := "2.11.8"
val sparkVersion = "2.3.0"


//spark core libraries
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion % "provided"

//Pureconfig for loading the config file
libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.12.1"

//scopt for commandline argument parsing
libraryDependencies += "com.github.scopt" %% "scopt" % "3.7.1"


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

