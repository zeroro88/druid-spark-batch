package org.apache.druid.indexer.spark

object TaskConfProvider {
  val taskConfURL = getClass.getResource("/" + SparkBatchIndexTask.TASK_TYPE_BASE + "_2.10_spec.json")
}
