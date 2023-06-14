/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.microsphere.spring.beans.factory.annotation;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.Set;

/**
 * Composite {@link AnnotatedInjectionDependencyResolver}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
public class AnnotatedInjectionDependencyResolvers {

    private final Iterable<AnnotatedInjectionDependencyResolver> resolvers;

    public AnnotatedInjectionDependencyResolvers(Iterable<AnnotatedInjectionDependencyResolver> resolvers) {
        this.resolvers = resolvers;
    }

    public void resolve(Field field, ConfigurableListableBeanFactory beanFactory, Set<String> dependentBeanNames) {
        resolvers.forEach(resolver -> resolver.resolve(field, beanFactory, dependentBeanNames));
    }

    public void resolve(Parameter parameter, ConfigurableListableBeanFactory beanFactory, Set<String> dependentBeanNames) {
        resolvers.forEach(resolver -> resolver.resolve(parameter, beanFactory, dependentBeanNames));
    }
}