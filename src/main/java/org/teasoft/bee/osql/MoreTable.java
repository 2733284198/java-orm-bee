/*
 * Copyright 2016-2020 the original author.All rights reserved.
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

import java.util.List;

/**
 * More table select(multi-table query).
 * <p>
 * example1:
<p>
public class Orders{
<p>	private Long id;
<p>	private String userid;
<p>	private String name;
<p>	private BigDecimal total;
<p>	private Timestamp createtime;
<p>	private String remark;
<p>	private String sequence;
<p>	
<p>//@JoinTable(mainField="userid", subField="username")
<p>//@JoinTable(mainField="userid", subField="username", joinType=JoinType.LEFT_JOIN)  //ok //... from orders left join user on orders.userid=user.username where ...
<p>	@JoinTable(mainField="userid,name", subField="username,name", joinType=JoinType.JOIN)
<p>//@JoinTable(mainField="userid", subField="username",subAlias="myuser" , joinType=JoinType.FULL_JOIN)
<p>//@JoinTable()
<p>	private User user;
<p>	
<p>	// ... get,set methods.
<p>	 }
<p>	 
<p>	 public class User {
<p>
<p>	private Long id;
<p>	private String email;
<p>	private String lastName;
<p>	private String name;
<p>	private String password;
<p>	private String username;
<p>	private Timestamp createtime;
<p>	
<p>		// ... get,set methods.
<p>	 }
<p>	 
<p>public class MoreTableExam {
<p>	
<p>	public static void main(String[] args) {
<p>		MoreTable moreTable=BeeFactory.getHoneyFactory().getMoreTable();
<p>		
<p>	 	Orders orders1=new Orders();
<p>		orders1.setUserid("bee"); 
<p>		orders1.setName("Bee(ORM Framework)");

<p>		User user=new User();
<p>		user.setEmail("beeUser@163.com");
<p>		orders1.setUser(user);
<p>	    List<Orders> list1 =moreTable.select(orders1);       //select
<p>//	List<Orders> list1 =moreTable.select(orders1,0,10);  //select,paging
<p>	    //... process list1
<p>	    }
<p>	 }

<p>--------------------------------
<p> example2:  List type sub entity field

<p>@Entity("Clazz")
<p>public class Clazz0 implements Serializable {
<p>
<p>	private static final long serialVersionUID = 1591972382398L;
<p>
<p>	private Integer id;
<p>	private String classname;
<p>	private String place;
<p>	private String teachername;
<p>	private String remark;
<p>	
<p>	@JoinTable(mainField="id", subField="classno", joinType=JoinType.LEFT_JOIN,subClass="Student")
<p>	private List<Student> studentList=new ArrayList<>();
<p>	//subClass="Student",  if sub Entity and main Entity in the same package, can use class name only.
<p>	//full like,  subClass="org.teasoft.exam.bee.osql.entity.Student")
<p>	
<p>	//... get,set method
<p>}
<p>
<p>public class Student implements Serializable {
<p>
<p>	private static final long serialVersionUID = 1591622324231L;
<p>
<p>	private Integer id;
<p>	private Integer sid;
<p>	private String name;
<p>	private Integer age;
<p>	private Boolean sex;
<p>	private String majorid;
<p>	private Boolean flag;
<p>	private Integer classno;
<p>	
<p>	//... get,set method
<p>}
<p>
<p>	public static void main(String[] args) {
<p>		
<p>		MoreTable moreTable = BeeFactoryHelper.getMoreTable();
<p>		Clazz0 c0=new Clazz0();
<p>		List<Clazz0> list0=moreTable.select(c0);
<p>		Printer.printList(list0); //print list
<p>}

 * @author Kingstar
 * @since  1.7
 */
public interface MoreTable extends CommOperate {

	/**
	 * According to entity object select records from database.
	 * @param entity table's entity(do not allow null).<br>
	 * entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty string as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @return list can contain more than one entity
	 */
	public <T> List<T> select(T entity);

	/**
	 * According to entity object select records from database.
	 * @param entity table's entity(do not allow null).<br>
	 * entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty string as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).
	 * @return list can contain more than one entity
	 */
	public <T> List<T> select(T entity, int start, int size);

	/**
	 * Select the records according to entity and condition.
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, 
	 * <br>it will be translate to field=value.Other can define with condition. 
	 * @return list can contain more than one entity
	 */
	public <T> List<T> select(T entity, Condition condition);
	
	/**
	 * set dynamic parameter for dynamic table & entity name
	 * <br>This method is called earlier than the select methods.
	 * @param para parameter name
	 * @param value parameter value
	 * @return MoreTable
	 * @since 1.9
	 */
	public MoreTable setDynamicParameter(String para,String value);
	
}
