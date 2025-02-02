/*
 * Copyright 2013-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.teasoft.bee.osql;

/**
 * Cache interface.
 * <br>Gen the key via sql string, then operate the cache by the key.
 * @author Kingstar
 * @since  1.4
 */
public interface Cache {
	
	/**
	 * Get the cache result by sql. 
	 * @param sql sql for select
	 * @return cache result set.
	 */
	public Object get(String sql);
	
	/**
	 * Put the result in the cache identify with sql.
	 * @param sql sql for select
	 * @param result result of select
	 */
	public void add(String sql,Object result);
	
	/**
	 * Clear the cache result of related table by sql.
	 * @param sql  sql for modify
	 */
	public void clear(String sql);
	
}
