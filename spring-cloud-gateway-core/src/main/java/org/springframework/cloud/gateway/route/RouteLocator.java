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
 * 路由定位器，服务获取路由信息
 * 1.可以通过 RouteDefinitionRouteLocator 获取 RouteDefinition ，并转换成 Route
 * @author Spencer Gibb
 */
// TODO: rename to Routes?
public interface RouteLocator {

	/**
	 * 获取路由
	 * @return
	 */
	Flux<Route> getRoutes();

}
