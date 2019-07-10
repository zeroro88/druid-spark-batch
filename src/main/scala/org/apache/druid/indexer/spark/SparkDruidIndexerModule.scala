/*
 *  Licensed to Metamarkets Group Inc. (Metamarkets) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  Metamarkets licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.druid.indexer.spark

import java.util

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.jsontype.NamedType
import com.fasterxml.jackson.databind.module.SimpleModule
import com.google.inject.Binder
import org.apache.druid.initialization.DruidModule

import scala.collection.JavaConverters._

class SparkDruidIndexerModule extends DruidModule
{
  override def getJacksonModules: util.List[_ <: Module] = {
    List(
      new SimpleModule("SparkDruidIndexer")
        .registerSubtypes(
          new NamedType(classOf[SparkBatchIndexTask], "index_spark")
        )
    ).asJava
  }

  override def configure(binder: Binder): Unit = {
    // NOOP
  }
}
