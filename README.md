# spark_scala
Getting started with Spark using Scala. 




For local testing - 
Create a file src/main/resources/data/core/input/staging/fscaccount_dim

<i>
COL1,col2,col3,COL4

A,B,C,1 

A,D,F,1 

X,Y,Z,1 

</i>
spark-submit --master spark://spark-master:6066  --deploy-mode cluster \
 --class com.org.project.jobs.CoreLoadJob \
  --conf "spark.driver.extraJavaOptions=-Djob-config.table-name=account_dim -Djob-config.path-staging=file:/source/spark_scala/src/main/resources/data/core/input/staging/ -Djob-config.path-conformed=file:/source/spark_scala/src/main/resources/data/core/output/core " \
  /source/spark_scala/target/scala-2.11/ProjectName-assembly-0.1.jar \
  -f "jobconfigs/core-load-job.conf" -s 0 -d 2021/01/19 

The spark submit command will return a json payload . 
Use the submissionId to fetch job status 

check job status -
curl http://spark://spark-master:6066/v1/submissions/status/{submissionId}
