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

import java.io.InputStream;
import java.io.InputStreamReader;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionXmlLoader;

import com.google.common.base.Charsets;

public class NdependRulesDefinition implements RulesDefinition {

  private final RulesDefinitionXmlLoader xmlLoader;

  public NdependRulesDefinition(RulesDefinitionXmlLoader xmlLoader) {
    this.xmlLoader = xmlLoader;
  }

  @Override
  public void define(Context context) {
    NewRepository repository = context.createRepository(NdependConfig.REPOSITORY_KEY, NdependConfig.LANGUAGE_KEY);
    repository.setName("NDepend - C#");
    InputStream stream = getClass().getResourceAsStream("/org/sonar/plugins/ndepend/rules.xml");
    xmlLoader.load(repository, new InputStreamReader(stream, Charsets.UTF_8));
    repository.done();
  }
}
