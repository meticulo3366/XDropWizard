/**
 * Copyright 2015 Knowm Inc. (http://knowm.org) and contributors.
 * Copyright 2013-2015 Xeiam LLC (http://xeiam.com) and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.knowm.xdropwizard;

import org.knowm.xdropwizard.health.TemplateHealthCheck;
import org.knowm.xdropwizard.resources.WeatherResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 * @author timmolter
 */
public class XDropWizardApplication extends Application<XDropWizardApplicationConfiguration> {

  public static void main(String[] args) throws Exception {

    new XDropWizardApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<XDropWizardApplicationConfiguration> bootstrap) {

    bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    bootstrap.addBundle(new ViewBundle<XDropWizardApplicationConfiguration>());

    }

  @Override
  public void run(XDropWizardApplicationConfiguration configuration, Environment environment) throws Exception {


    // Add object to ServletContext for accessing from Sundial Jobs
    environment.getApplicationContext().setAttribute("MyKey", "MyObject");

    final String template = configuration.getTemplate();
    final String defaultName = configuration.getDefaultName();
    environment.jersey().register(new WeatherResource("San Fran", 32, 0));
    environment.healthChecks().register("TemplateHealth", new TemplateHealthCheck(template));


    // TASKS ////////////////////////////
    // tasks are things that should run triggered by a POST, but don't need to respond
    // none

    // RESOURCES ////////////////////////////

    //    environment.jersey().register(new XChartResource());
    //    environment.jersey().register(new ViewMarkdownResource());

    environment.jersey().packages("org.knowm.xdropwizard.resources");
  }
 }

