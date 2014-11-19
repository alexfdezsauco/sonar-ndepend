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

import org.sonar.api.resources.Project;

import static org.fest.assertions.Assertions.assertThat;

import static org.mockito.Mockito.when;
import org.junit.Test;
import org.sonar.api.config.Settings;
import static org.mockito.Mockito.mock;

public class NdependSensorTest {

  @Test
  public void shouldExecuteOnProjectWhenNdProjNotExists() {
    Settings settings = mock(Settings.class);
    Project project = mock(Project.class);

    NdependSensor sensor = new NdependSensor(settings);

    when(project.getPath()).thenReturn("");
    when(settings.getString(NdependConfig.PROJECT_PATH_PROPERTY_KEY)).thenReturn("do-not-exists");
    assertThat(sensor.shouldExecuteOnProject(project)).isFalse();
  }

}
