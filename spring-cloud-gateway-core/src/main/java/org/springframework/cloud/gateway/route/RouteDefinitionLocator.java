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
 * 路由定义信息的定位器，
 * 负责读取路由配置( org.springframework.cloud.gateway.route.RouteDefinition
 * 子类实现类
 *  1.CachingRouteDefinitionLocator -RouteDefinitionLocator包装类， 缓存目标RouteDefinitionLocator 为routeDefinitions提供缓存功能
 *  2.CompositeRouteDefinitionLocator -RouteDefinitionLocator包装类，组合多种 RouteDefinitionLocator 的实现，为 routeDefinitions提供统一入口
 *  3.PropertiesRouteDefinitionLocator-从配置文件(GatewayProperties 例如，YML / Properties 等 ) 读取RouteDefinition
 *  4.DiscoveryClientRouteDefinitionLocator-从注册中心( 例如，Eureka / Consul / Zookeeper / Etcd 等 )读取RouteDefinition
 *  5.RouteDefinitionRepository-从存储器( 例如，内存 / Redis / MySQL 等 )读取RouteDefinition
 * @author Spencer Gibb
 */
public interface RouteDefinitionLocator {

	/**
	 * 获取RouteDefinition
	 * @return
	 */
	Flux<RouteDefinition> getRouteDefinitions();

}
