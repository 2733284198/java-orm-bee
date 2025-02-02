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
 * Dictionary conversion annotation is used to filter and process the returned data 
 * <br>of query according to rules. If there is no mapping, it will not be replaced.
 * <br>Version 1.11, general processing implementation is not provided yet
<p>
<p> data in Databsee:
<p> flag=null
<p> flag=1
<p> flag=0
<p> flag=
<p> @&nbsp;Dict(map="0=No,1=Yes",nullToValue="?")
<p> @&nbsp;Dict(map="0=No,1=Yes,=empty,",nullToValue="?")
<p> private String flag;
<p> after process:
<p> flag=?
<p> flag=Yes
<p> flag=No
<p> flag=empty
 
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dict {

	String map();

	/**
	 * The value of the replacement when the field value is null.
	 * @return value replace for null
	 */
	String nullToValue() default "@#placeholderStr(default do not process)";

}
