
Bee
=========
**Easy for Stronger.**   
**Bee** is an ORM framework.   
**Bee** is an easy and high efficiency ORM framework.  


## Feature & Function: 

**Support many Database**(MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL and so on) and easy extend。 

**V1.0**  
Single entity(table) Suid (select,update,insert,delete) object-oriented operation.  
Automatically generate the Javabean via DB table or view.  
Convention-over-configuration:Javabean no annotation,no xml.  
Automatically mapping the table column and the Javabean field.  
Javabean support the raw type:int,double,and so on.  
PreparedStatement support.  
Procedure support.  
Native SQL support.  
Batch operate support.  
Transaction support.  
Automatic filter the null and empty field for default.  
MAX,MIN,SUM,AVG,COUNT support.  
Order by,Paging.  
Select some field.  
Dynamic & random combination of query conditions,no need to prepare the interface in advance; new query requirements, no need to change the query interface.  
All Suid(select,update,insert,delete) operation use the same Bee interface,no longer need any new dao interface.  
Users/Developer only need to pay attention to the Bee interface.  

**V1.1**  
Json format Result support.  
Procedure(Query type) support.  

**V1.2**  
Customer sql support #{para} placeholder,eg:name=#{name}; like keyword support:#{%para%},#{%para},#{para%}  

**V1.3**  
Add: chain programming(select&update)

**V1.4**  
Add: selectById,deleteById  
Add: public &lt;T> List&lt;T> select(T entity,String selectFields,int start,int size)  
Enhance: selectJson add config:ignoreNull;date,time,timestamp Wit hMillisecond format  
Enhance: List<String[]> select(String sql), add config:nullToEmptyString  
Enhance ResultSet Cache mechanism  
Cache support: never,forever,forever and modify Syn,resultSet's size control.  
Add: SysValue annotation  

**V1.5**  
1.add NameTranslate interface and default implement class,support customize translation rule of DB and Java naming.  
2.support jdbcTypeToFieldType-{DbName}.properties,define DB's column type map java type.  
3.enhance Oracle's type translation；other DB can define the column type and java type.  
mapping in file: jdbcTypeToFieldType-{DbName}.properties.  
4.add special entity and table name mapping support.  
  Optimize table name to entity name.  
5.add BeeIllegalEntityException for check illegal Entity.  
6.add create file util.  
7.enhance paging function,and support customize extend interface.  
8.fix ORA-00911 bug,it will cause when operate oracle DB with JDBC.  
9.override the op method for default equal(in UpdateImpl and SelectImpl).  
10.add override OperationType in enum Op.  

**V1.6**  
1.Suid add complicate select oriented object. 
  Suid add method:public &lt;T> List&lt;T> select(T entity,Condition condition);  
  support complicate select;support to use between、like、in、>、>=、<、<=、group by、having、order by、paging  at same time.  
2.SuidRich add complicate select oriented object.  
SuidRich add new method:  
select(T entity, IncludeType includeType, Condition condition)  
selectJson(T entity, IncludeType includeType, Condition condition)  
3.SuidRich add new method:  
updateBy(T entity,String whereFields)  
updateBy(T entity,String whereFields,IncludeType includeType)  
4.add SqlNullException in PreparedSqlLib.  
V1.6.1  
1.PreparedSql add start & size paging parameters in relative methods.  
2.add Deprecated to modify method in PreparedSql.  
3.update getFieldSet method's return type with Java generics.  
4.fix bug.ConditionImpl's fieldSet need record the field in between method.  

**V1.7**  
more tables select oriented object support.  
1.support one to one,one to many,many to one,many to many.  
2.support join(inner join), left join,right join, no join.  
3.The select operations of single table and more tables do not affect each other.  
**V1.7.1**  
gen javabean support create comment.  
support getColumnNames,getFieldNames method in GenBean.  
fix the bug for the define sql no placeholder.  
fix the bug for page in PreparedSqlLib.  
enhance the exception when the sql string is null(CustomSql).  
fix bug about cache.  
fix bug in SelectImpl.  
fix bug for inner join condition style.  
add FileCreator interface.  
**V1.7.2**  
support set the default naming translate type by config.  
enhance function of BeeFactory.  
adjust the format of SQL log.  
support set the date format by config.  
[move test/example to new project bee-exam](../../../bee-exam).  
add class FileLogger for write the log in file.  
support control print log level or not by config.  
enhance test case/example.  
support generate the file according to template.  
add method delete(T entity, Condition condition) in Suid.  
support setting not allowed delete whole records in one table while Object Oriented way.  
SuidRich add 2 methods:  
updateBy(T entity,String whereFields,Condition condition)  
update(T entity,String updateFields,Condition condition)  
add nocache config support.  
add method setAdd,setMultiply in Condition for set value in SQL update.  

**V1.8**   
**Add Distributed Feature:**   
1.Add multi-DataSource support(Write/Read, only Split Database).  
add multi-DataSource no need change the Java code.  
add the route interface of multi-Datasource.  
add multi-DataSource route.  
add multi-DataSource config.  
support refresh multi-DataSource config information.  
2.Generate global unique id number in distributed environment.  
3.Generate Serial Unique id number in one workid of distributed environment.  
Independent clock,workerid can config and easily expand.  
Implement algorithms:SerialUniqueId,OneTimeSnowflakeId,PearFlowerId.  
Support GenId Factory,and can config the id generator.  
4.Gen Serial Unique Id for all Table's Long Id field as primary key.  
**Enhance Function:**   
5.The same database sub table support, dynamic table name mapping support.  
Entity and any table name mapping support.  
Suid add one method:	
public Suid setDynamicParameter(String para,String value);  
add 2 annotation:@Table,@Entity.  
6.Use 'for update' lock some select record(s).   
public Condition forUpdate()  
7.Added support for advanced update set,   
Complex query and multi table query support only project some fields.   
Add 5 methods in Condition:  
public Condition setAdd(String field, String fieldName)  
public Condition setMultiply(String field, String fieldName)  
public Condition set(String fieldNmae, Number num)  
public Condition set(String fieldNmae, String value)  
public Condition selectField(String fieldList)  
8.Support show type of data in sql and show ExecutableSql:  
bee.osql.showSQL.showType=false  
bee.osql.showSQL.showExecutableSql=false  
9.Add one method in SuidRich:  
public &lt;T> int update(T entity,Condition condition);  
Add three methods in PreparedSql:  
public String selectJson(String sqlStr);  
public List<String[]> select(String sql);  
public String selectFun(String sql);  
10.Oracle DATE column mapping to Timestamp,fix the problem:miss the hour,minute,second in Oracle DATE column.  
11.GenFiles support upper case first letter,eg: #{entityName?up1}.  
**Fix bug:**   
12.fixed cache bug:genkey;clear cache for batch insert.  
fixed bug:parse the json has extra comma.	
fixed null bug about:PreparedSql's method select(String sql,Object preValues[]).  
fixed bug about Oracle more table paing.  

**v1.8.15**(2020-10-01 3Festivals)  
1.Enhance support for H2,SQLite,PostgreSQL.  
2.Enhance page funtion,paging para also use placeholder.  
3.Can be used in zero configuration.  
4.Enhance PearFlowerId algorithm that it will produce even number with continuous mantissa of 0 when is often not used (there are no such defect in SerialUniqueId and OneTimeSnowflakeId).  
5.Enhance Log function.  
6.Fixed json transform bug.  

**v1.8.99**(2020-10-25 Double Ninth Festival)  
1.Support lower and upper case option for SQL KeyWord.  
2.Cache sql key support MD5 string.  
3.Optimize the way of setting DB information with Honeyconfig.  
4.Fix bug about checkSelectField.  

**v1.8.15**(2020-10-01 3Festivals)  
1.Enhance support for H2,SQLite,PostgreSQL.  
2.Enhance page funtion,paging para also use placeholder.  
3.Can be used in zero configuration.  
4.Enhance PearFlowerId algorithm that it will produce even number with continuous mantissa of 0 when is often not used (there are no such defect in SerialUniqueId and OneTimeSnowflakeId).  
5.Enhance Log function.  
6.Fixed json transform bug.  

**v1.8.99**(2020-10-25 Double Ninth Festival)  
1.Support lower and upper case option for SQL KeyWord.  
2.Cache sql key support MD5 string.  
3.Optimize the way of setting DB information with Honeyconfig.  
4.Fix bug about checkSelectField.  

**V1.9**  
SuidRich add new methods support list parameter in batch insert.  
enhance SuidRich function, SuidRich add method:  
	public <T> List<String[]> selectString(T entity,Condition condition);  
	public <T> int updateById(T entity,Condition condition);  
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun, Condition condition);  
	public <T> int count(T entity);  
	public <T> int count(T entity, Condition condition);  
	public <T> boolean exist(T entity); //check the record whether exist in table  
SuidRich adjust methods selectById for unique entity and intelligently judge the Javabean id type of string id parameter.  
Suid add method insertAndReturnId.  
enhance aggregate function cont,sum,avg,min,max,Condition add method:  
	public Condition selectFun(FunctionType functionType,String fieldForFun);  
	public Condition selectFun(FunctionType functionType,String fieldForFun,String alias);  
Condition add method:opWithField,setWithField support like :field1=field2  
Condition add method:selectDistinctField,support distinct as select distinct(userid) from table_name  
MapSuid,no need Javabean, use map to set the entity information that needs to be transformed and operate the database(select/insert/delete record).  
support read Excel(*.xls,*.xlsx), converting data into List<String[]> and importing them into database(bee-ext).  
more table join select support more join condition.  
same Connection for some ORM operation.  
support different type muli-Ds at same time.  
IncludeType support exclude "  ".  
add Ignore Annotation, ignore the field which do not want to transfer.  
support define start and end token when generate file by template.  
enhance DB conn management.  
enhance code quality.  
enhance chain coding:Select,Update.  
adjust config information of bee.properties,HoneyConfig.  
Bee integration with Spring Boot,provide bee-spring-boot-starter.  
support use Javabean create the DB table.  
fix the problem that the fields with the same name will be confused in some databases(oracle) when multi table paging query.  
fixed: update is default by id,but no id field or id is null,will have exception.  
fixed: cache bug.  
fixed: about getRangeId(int sizeOfIds) of GenId.  
fixed: in jdk 11,LoggerFactory use log4j2,have exception.  
when entity is view(not table), recommend put in bee.osql.cache.never(bee.properties).

**V1.9.8**(2021 Mid-Autumn Day)  
SuidRich add 4 method:  
public <T> int save(T entity);  
public <T> int update(T oldEntity,T newEntity);  
public <T> String selectJson(T entity, String selectField);  
public <T> String selectJson(T entity, String selectField, int start, int size);  

MoreTable(more table select):  
support List type field for more tables join;  
support two sub tables join(inner join,right join, left join);  
support one sub table have another join sub table;  
if all fields is null, the sub table field will set null;  
annotation JoinTable add method:subClass() for List type field   
Condition add method:  
public Condition opOn(String field, Op Op, Object value);  

MapSuid(the Javabean corresponding to the table is not required):  
add method update,count,paging select, add and adjust insert and insertAndReturnId.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSql.  
add method count(MapSql mapSql),update(MapSql mapSql),insertAndReturnId(MapSql mapSql),support page in MapSuid.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSqlImpl.  
add method toUpdateSqlByMap ,toCountSqlByMap ,support page in MapSqlProcessor.  
add method count(MapSql mapSql),update(MapSql mapSql),support page in MapSuidImpl.  
MapSuidImpl change two different method:insert(MapSql mapSql) & insertAndReturnId(MapSql mapSql)  

PreparedSqlLib support selectMapList method.  
Read/Write multi-DataSource support different type DataSource.  
Logger: two method support have parameter Throwable.  
sql log support config the log level.  
add class StreamUtil  
ObjectUtils add one method: isTrue(Boolean b)  
enhance check field  
use LinkedHashMap in List&lt;Map> result for selectMapList(String sql).  
Condition support condition.set("fieldName", null).  
selectJson support config long to string  
enhance autoGenBean ,support to generate SQL Json Script.  
Add general search function support (simplify back-end complex query programming).  
enhance multi-thread support.  
custom the path of bee.properties.  
Generate Javabean(GenBean) support type:JSON,TEXT.  

fix bug for ExecutableSql.  
transfer the the field of 'order by'.  
fix null bug in create() of ObjectCreatorFactory.  
fix bug for max column number(excel in bee-ext). 
fix bug about HoneyContext  
fix bug about checkPackageByClass  
fix bug about multi-thread safe in ConditionHelper.   

**V1.11**  
V1.11.0.1.1(**2022 New Year**)  
SuidRich add method:  
  public <T> long insertAndReturnId(T entity,IncludeType includeType);  
PreparedSql add method:  
  public <T> List<T> select(String sql,T returnType);  
add annotation PrimaryKey  
MapSqlKey support PrimaryKey  
BF is shortcut for BeeFactoryHelper  
Enhance:config info add trim() about multi-DataSource Write/Read  
fix a bug for naming transfer  

V1.11.0.2.1(**2022 Spring Festival**)  
add function: Interceptor、multi-tenant  
add Interceptor,InterceptorChain  
add DefaultInterceptor,CommInterceptorChain,DefaultInterceptorChain  

V1.11.0.2.4(**2022 Beijing Winter Olympics**)  
level tow ext cache support  
Redis cache support  
add BeeExtCache,DefaultBeeExtCache  
add BeeExtRedisCache  

V1.11.0.2.15(**2022 the Lantern Festival**)  
add annotation:Datetime,Createtime,Updatetime;JustFetch  
add support Jndi DataSource  
check MapSqlKey value 
 
V1.11.0.2.20(**Honor**)  
Optimize use different Database Type at same time(multi-Ds)  
Support use differnt type Database at the same time(eg:use Mysql,Oracle,SQL Server at same time)  
PreparedSql,MapSuid support Interceptor  
Suid,PreparedSql,MapSuid support get DataSource,get InterceptorChain  
Suid,PreparedSql,MapSuid,MoreTable add method:setDataSourceName,getDataSourceName,getInterceptorChain  
add Annotation:  
AnnotationHandler,AutoSetString  
Desensitize    
ReplaceInto,MySQL replace into  
MultiTenancy  
BeforeReturnAnnotationHandler,AbstractDictI18nDefaultHandler  
Dict  
DictI18n  

V1.11.0.2.28  (**Special Day**)  
add ShardingStruct prepare for sharding.  
add Column annotation support to extend mapping column and Javabean field name.  
support custom TypeHandler,and process the ResultSet.  
PreparedSql custom sql support more table select,and return more table struct Javabean.  
fixed bug:  
More table self association query of the same entity forbid multi-self-cycles  

V1.11.0.3.8  (**Lady First**)  
add SetParaTypeConvert for convert PreparedStatement parameter.  
Javabean use java.util.Date type for SUID compatibility processing.  
SQLite get the timestamp result for conversion.  
The Json field of DB is automatically converted to the attribute marked with Json annotation of Javabean(Javabean structure corresponding to Json). 

V1.11.0.3.12  (**Tree Planting Day**)  
Ddl.java uses Javabean to create tables, supports the mapping between Java and DB field types, and supports the setting java_dbtype mapping.  
Ddl.java is compatible with raw char type and java.util.Date.  
PreparedSql support batch insert.  
Support Suid instance set NameTranslate.  
Add DbFeature Registry,it is easy for setting custom database dialect.  
Support Cassandra.  

V1.11.0.3.20  (**Spring Equinox**)  
add Custom dynamic SQL token,@in,@toIsNULL1,@toIsNULL2,&lt;if isNotNull>,&lt;if isNotBlank>.  
dynamic SQL list transfer list to SQL in eg:in (1,2,3),no need foreach;batch insert also no need foreach.  
Separate CN and EN API.  

V1.11.0.4.22 (**The World Earth Day**)  
Add registry interface; Add nameregistry.  
Change serializer throws exceptions type.  
Mapsuid and mapsql support parsing string to boolean type.  
Genbean, which does not support JDBC type, reminds you which file to set;  
Genbean support config where override the old file;  
Genbean support gen javabean's field file;  
SuidRich's method selectString support variable-length arguments:  
 public <T> List<String[]> selectString(T entity,String... selectFields);  
CommInterceptorChain check whether add same class.
SystemLogger supports setting log level to facilitate development and debugging.  
The logger add method: public static void debug (string MSG, throwable T) (convenient for development and debugging).  
Nocache add log prompt.  
Improve cache security.  
Add preload SPI interface Preload.  
Add InterceptorChainRegistry, an interceptor registrar for global use.  
Add configuration item:  
pagingWithLimitOffset    
notCatchModifyDuplicateException    
notShowModifyDuplicateException    
fixed bug for type converter.  
fixed bug about @PrimaryKey in Suid update(entity).  

V1.11.0.4.29  
The configuration file supports multi-environment differentiated configuration.  
SuidRich,public <T> int update(T oldEntity, T newEntity) Interceptors only handle newEntity.  


**V1.17(2022·Mid-Autumn Day)**  

**V1.17.0.10**  
fixed bug:
1)prototype InterceptorChain  
2)if Android SQLiteDatabase instance is not open,get a new one  

**V1.17.0.9(Good,Better·Seventh Evening)**  
1)Transaction annotation @tran, which can be used at the class level  
2)the ref field class {Entity}_F,add ALL_NAMES field,can get the field list of the Entity  
3)Ddl.java support create index(normal,unique),combine Primary key  
4)auto get JdbcToJavaType  
5)bee.osql.naming.translateType add type 4(DbUpperAndJavaLower):Db Upper And Java Lower,ignore case,the name is same.  
6)When multiple DB naming are used, the translatetype part is added to the cache  
7)@Ignore(@Transient) compatible with JPA(interface AnnoAdapter)  
8)condition.op(fieldName, Op.in, Value) add support List,Set,Number Array,one Number element  
9)condition.opOn(fieldName, Op.in, Value) Value can just use Number and String  
10)Enhance:like;Op add likeLeft,likeRight,likeLeftRight(the value of the parameter will be escaped by the framework)  
11)Enhance:dynamic calculation of the number of ExcelReader data columns  
12)Enhance: SQLite date type transfer support  
13)Enhance:GenBean generate Javabean,when id type is BigDecimal,will be set to Long  
14)fixed bug:level 2 cache;TypeHandlerRegistry return value  


**V1.17.0.8**  
1)Primary key support the field is not "id",except the Long, the type can be Integer or String    
2)Support the automatic generation of the primary key by annotation(GenId,GenUUID)  
3)@Column support default implement(Strongly recommend: do not use this Annotation in new system)  
4)@Table,@Column,@PrimaryKey(@Id) compatible with JPA(interface AnnoAdapter)  
5)Distributed id generator supports setting the starting year:bee.distribution.genid.startYear  
6)Chain programming SelectImpl,UpdateImpl adjust check rule for field  

**V1.17.0.7**  
1)**add support HarmonyOS ORM function**  
2)In **HarmonyOS and Android** environment can use the same ORM code with Bee  
3)support HarmonyOS Log:ohos.hiviewdfx.HiLog  

**V1.17.0.6**  
1)**add support Android ORM function,you can use Bee for SQLite DB in Android environment.**  
2)support android.util.Log  
3)Ddl: optimize process if the table is exist  
4)add log tip the dsName(dataSource name) when multi-dataSource  
5)when paging , the size is 0, return emptyList  

V1.17.0.5  
1)Sql Server support (start,size) paging  
2)@Tran transaction annotation  
