/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.gateway.route;

import reactor.core.publisher.Flux;

/**
 * 组合多个 RouteDefinitionLocator 的实现，为 routeDefinitions提供统一入口
 * @author Spencer Gibb
 */
public class CompositeRouteDefinitionLocator implements RouteDefinitionLocator {

	/**
	 * 所有路由定义定位器实例集合
	 */
	private final Flux<RouteDefinitionLocator> delegates;

	public CompositeRouteDefinitionLocator(Flux<RouteDefinitionLocator> delegates) {
		this.delegates = delegates;
	}

	@Override
	public Flux<RouteDefinition> getRouteDefinitions() {
		//将各个RouteDefinitionLocator的getRouteDefinitions合并返回统一的Flux<RouteDefinition>
		return this.delegates.flatMap(RouteDefinitionLocator::getRouteDefinitions);
	}

}
