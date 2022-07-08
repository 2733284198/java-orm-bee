/*
 * Copyright 2016-2022 the original author.All rights reserved.
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

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于插入数据时,生成主键id值(UUID生成),字段类型要求是String.
 * 建议使用Long类型的id主键,如@GenId,具体分布式全局唯一特性,效率也高.
 * 统一配置方式,可使用bee.properties里,bee.distribution.genid.开头的配置.
 * @author Kingstar
 * @since  1.17
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GenUUID {

	/**
	 * whether override the old id
	 * @return the boolean value of override
	 */
	boolean override() default false;
	
	/**
	 * whether need the separator("-"),default is false.
	 * @return
	 */
	boolean useSeparator() default false;

}
