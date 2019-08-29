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

package org.springframework.cloud.gateway.handler.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.HttpMethod;
import org.springframework.web.server.ServerWebExchange;

/**
 * 请求方式（GET,POST,DEL,PUT）校验匹配创建工厂
 * @author Spencer Gibb
 */
public class MethodRoutePredicateFactory
		extends AbstractRoutePredicateFactory<MethodRoutePredicateFactory.Config> {

	/**
	 * Method key.
	 */
	public static final String METHOD_KEY = "method";

	public MethodRoutePredicateFactory() {
		super(Config.class);
	}

	@Override
	public List<String> shortcutFieldOrder() {
		return Arrays.asList(METHOD_KEY);
	}

	@Override
	public Predicate<ServerWebExchange> apply(Config config) {
		return new GatewayPredicate() {
			@Override
			public boolean test(ServerWebExchange exchange) {
				//获取当前请求的HttpMethod
				HttpMethod requestMethod = exchange.getRequest().getMethod();
				//校验请求HttpMethod与配置是否一致
				return requestMethod == config.getMethod();
			}

			@Override
			public String toString() {
				return String.format("Method: %s", config.getMethod());
			}
		};
	}

	public static class Config {
		/**
		 * http 请求Method
		 */
		private HttpMethod method;

		public HttpMethod getMethod() {
			return method;
		}

		public void setMethod(HttpMethod method) {
			this.method = method;
		}

	}

}
