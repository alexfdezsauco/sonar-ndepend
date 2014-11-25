/*
 * SonarQube NDepend Plugin
 * Copyright (C) 2014 Criteo
 * dev@sonar.codehaus.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sonar.plugins.ndepend;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.sonar.api.config.PropertyDefinition;

import com.google.common.collect.ImmutableSet;

public class NdependPluginTest {

  @Test
  public void test() {
    assertThat(propertyKeys(new NdependPlugin().getExtensions())).containsOnly(
      "sonar.ndepend.solutionPath",
      "sonar.ndepend.ndependPath");
  }

  private static Set<String> propertyKeys(List extensions) {
    ImmutableSet.Builder<String> builder = ImmutableSet.builder();
    for (Object extension : extensions) {
      if (extension instanceof PropertyDefinition) {
        PropertyDefinition property = (PropertyDefinition) extension;
        builder.add(property.key());
      }
    }
    return builder.build();
  }
}
