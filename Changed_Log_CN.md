
Bee
=========
#### 工欲善其事必先利其器！——《论语·卫灵公》    
**Bee** 是一个 Java ORM框架利器, 它的开发速度快, 编码少, 还很简单！       
**Bee** 编码复杂度是O(1)，即用了Bee，**无论多少个表**,你都可以不用另外再写dao代码。  


## 详细功能介绍: 

**多种DB**支持轻松扩展(MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL等直接可用)。 

**V1.0**  
单表Suid(select,update,insert,delete)面向对象方式的操作,方法名与数据库Suid操作对应.  
自动通过DB的表或视图生成Javabean.  
约定优于配置:Javabean没有注解,没有xml,只是纯的Javabean即可(为什么要给Javabean那么重的负担呢??!!!).  
自动映射表的列与的字段.  
Javabean支持原生类型:int,double等.  
使用PreparedStatement防止SQL注入攻击.  
Procedure存储过程支持.  
原生SQL支持.  
批处理操作支持.  
Transaction事务支持.  
自动过滤null和空字符串(作为默认实现).  
SQL中函数:MAX,MIN,SUM,AVG,COUNT支持.  
SQL中排序,分页支持.  
支持只查询一部分字段.  
动态/任意组合查询条件,不需要提前准备dao接口,有新的查询需求也不用修改或添加接口.  
所有的suid操作都是用同一个bee接口,不用再定义任何新的dao接口,更不用实现dao接口.  
用户/开发者仅需要关注bee接口如何调用即可.  

**V1.1**  
**直接返回Json**格式查询结果支持.  
Procedure存储过程支持(CallableStatement.executeQuery).  

**V1.2**  
用户自定义sql支持#{para}占位参数设置，如：eg:name=#{name}; like查询 支持:#{%para%},#{%para},#{para%} 

**V1.3**  
增加:select/update链式编程

**V1.4**  
增加: selectById,deleteById  
增加: public &lt;T> List&lt;T> select(T entity,String selectFields,int start,int size)  
增加: selectJson add config:ignoreNull;date,time,timestamp Wit hMillisecond format  
增加: List<String[]> select(String sql), add config:nullToEmptyString  
完善查询结果缓存机制(一级缓存可**对用户编程透明**,也可进行细粒度配置调优控制)  
**一级缓存**即可支持: **不缓存列表,永久缓存列表,可更新的长久缓存列表**,结果集超过一定大小可不放缓存 等细粒度配置调优控制.  
增加: SysValue注解  

**V1.5**  
1.增加NameTranslate接口和默认转换实现类，支持Java与DB命名转换规则自定义。  
2.支持jdbcTypeToFieldType-{DbName}.properties,自定义DB列转Java的类型。  
3.完善Oracle类型转换；**多种DB支持轻松扩展**:可将某种DB特有的类型映射关系放在文件:  
  jdbcTypeToFieldType-{DbName}.properties，即可完成自动转换。  
4.增加entity实体名与表名的特殊映射关系支持,优化表名转实体名的情况。  
5.过滤非法实体类型。  
6.增加**文件生成工具**。  
7.完善分页功能,并支持自定义扩展接口。  
8.修复Oracle JDBC操作数据库ORA-00911 bug。  
9.增加op方法重载，默认为等号(in UpdateImpl and SelectImpl)。  
10.增加OperationType重载(in enum Op)。  

**V1.6**  
1.Suid增加**面向对象方式复杂查询**支持.  
  Suid接口增加方法:public &lt;T> List&lt;T> select(T entity,Condition condition);  
   支持范围查询;支持同时使用范围查询、模糊查询、in、>、>=、<、<=、分组、having过滤、排序、分页等复杂查询。  
2.SuidRich增加面向对象方式复杂查询支持.  
SuidRich接口增加方法:  
select(T entity, IncludeType includeType, Condition condition)  
selectJson(T entity, IncludeType includeType, Condition condition)  
3.SuidRich增加更新方法:  
updateBy(T entity,String whereFieldList)  
updateBy(T entity,String whereFieldList,IncludeType includeType)  
4.add SqlNullException in PreparedSqlLib.  
V1.6.1  
1.PreparedSql相关方法添加start,size分页参数，使自定义sql查询的分页更方便，  
    自定义的sql语句中不用带分页部分,移植性更高。  
2.PreparedSql的modify加注解:@Deprecated  
3.Condition的方法getFieldSet返回值由Set改为Set<String>。  
4.fix bug.ConditionImpl的fieldSet需要记录在between方法使用的记录。  

**V1.7**  
增加面向对象方式**多表查询**支持.  
1.**支持一对一,一对多,多对一,多对多**。  
2.支持join(inner join), left join,right join, no join。  
3.单表、多表的查询操作互不干扰。  
**V1.7.1**  
创建javabean支持添加注释.  
创建javabean的类新增getColumnNames,getFieldNames方法.  
修复自定义sql没有占位符时出现的bug.  
修复在PreparedSqlLib分页的bug.  
完善在CustomSql中sql字符串为null的异常.  
修复关于缓存的bug.  
修复SelectImpl的bug. 
修复内连接条件风格转换的bug.  
添加FileCreator接口.  
**V1.7.2**   
可以通过配置选择已实现的命名转换规则.  
完善BeeFactory类的功能.  
调整SQL输出日志格式.  
日期格式可以通过配置定义.  
[将测试/使用实例迁移到bee-exam项目](../../../bee-exam).  
添加类FileLogger,用于将日志记录到文件中.  
可以通过配置控制是否输出日志级别.  
完善测试用例/使用样例.  
支持使用模板快速生成文件.  
在Suid接口增加方法 delete(T entity, Condition condition).  
支持配置是否允许删除一个表的所有数据(在面向对象方式下有效).  
SuidRich 新增两个方法:  
  updateBy(T entity,String whereFields,Condition condition)  
  update(T entity,String updateFields,Condition condition)  
新增不使用缓存配置支持.  
Condition接口新增方法setAdd,setMultiply用于设置SQL中update操作的set设置.  

**V1.8**   
**增加分布式特性:**   
1.添加多数据源支持(读写分离一主多从, 仅分库).  
增加多数据源无需改动Java代码(对编码透明)，只需添加配置信息即可. 
添加多数据源路由接口. 
添加多数据源路由实现算法.  
添加多数据源配置.  
支持配置信息刷新.  
2.分布式环境下生成全局唯一数字递增id.	  
分布式环境下生成连续单调递增(在一个workerid内),全局唯一数字id.  
3.Bee分布式唯一id算法特性:不依赖时钟,workerid可配置,易扩展.	  
具体算法实现:SerialUniqueId,OneTimeSnowflakeId,PearFlowerId.		  
提供id生成工厂:GenIdFactory,且可配置id生成器具体实现类.	  
4.可为所有表的Long型id字段自动生成全局唯一id主键.  
**增强功能:**   
5.同库分表支持,动态表名映射支持.  
实体与任意表名映射支持. 
Suid add one method:	
public Suid setDynamicParameter(String para,String value);  
add 2 annotation:@Table,@Entity.  
6.添加for update功能,用于锁住某个表的一些记录.  
public Condition forUpdate()  
7.增加高级更新设置值支持,复杂查询、多表查询支持只查部分字段:	
在Condition添加5个新方法:  
public Condition setAdd(String field, String fieldName)  
public Condition setMultiply(String field, String fieldName)  
public Condition set(String fieldNmae, Number num)  
public Condition set(String fieldNmae, String value)  
public Condition selectField(String fieldList)  
8.支持SQL输出日志配置,占位参数可显示参数,可输出直接可执行的sql:  
bee.osql.showSQL.showType=true  
bee.osql.showSQL.showExecutableSql=true  
9.SuidRich添加一个新方法:  
public &lt;T> int update(T entity,Condition condition);  
PreparedSql添加三个新方法:  
public String selectJson(String sqlStr);  
public List<String[]> select(String sql);  
public String selectFun(String sql);  
10.Oracle DATE字段在Javabean里转成java.sql.Date存入数据库时会丢失时分秒，
转成Timestamp可以解决这个问题。  
11.GenFiles根据模板自动生成文件代码添加支持首字母大写,如: #{entityName?up1}.  
**修复原有问题:**   
12.bug修复:缓存key生成;批插入后清缓存.  
修复缺陷:解析json时多余的逗号错误.  
修复null bug,关于方法:PreparedSql's method select(String sql,Object preValues[]).  
修复关于oracle多表查询分页bug.  
	

**v1.8.15**(2020-10-01 3节日)  
1.增强对数据库H2,SQLite,PostgreSQL的支持.  
2.优化分页功能,分页参数也用占位符.  
3.可零配置使用.  
4.完善梨花算法经常不使用时,产生连续尾数为0的偶数的问题(SerialUniqueId和OneTimeSnowflakeId这两种ID生成算法不会有这些缺陷).  
5.完善日志Log功能.  
6.修复json转换bug.  

**v1.8.99**(2020-10-25 重阳节)  
1.SQL关键字支持可配置大写或小写输出.  
2.SQL缓存key可用MD5字符.  
3.优化利用HoneyConfig设置DB信息的方式.  
4.修复关于checkSelectField的bug.  

**V1.9**  
SuidRich新增支持List参数的批量插入方法.  
增强SuidRich功能, SuidRich增加方法:  
	public <T> List<String[]> selectString(T entity,Condition condition);  
	public <T> int updateById(T entity,Condition condition);  
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun, Condition condition);  
	public <T> int count(T entity);  
	public <T> int count(T entity, Condition condition);  
	public <T> boolean exist(T entity); //判断记录是否存在  
SuidRich调整selectById方法且String类型参数的id智能识别Javabean的id类型.  
Suid新增insertAndReturnId方法.  
加强聚合函数cont,sum,avg,min,max功能,Condition增加方法:  
	public Condition selectFun(FunctionType functionType,String fieldForFun);  
	public Condition selectFun(FunctionType functionType,String fieldForFun,String alias);  
Condition 添加方法:opWithField,setWithField 支持像:field1=field2的表达式  
Condition 添加方法:selectDistinctField,支持distinct像 select distinct(userid) from table_name  
MapSuid,无需Javabean，用map承载需要转换的实体信息，操作数据库(查询,插入,删除数据).  
支持读取Excel(*.xls,*.xlsx),并将数据转成List<String[]>,且导入到数据库(bee-ext).  
多表关联查询支持多个关联条件.  
多个ORM操作使用同一个Connection.  
支持同时使用不同数据库(多个数据源).  
支持长度大于0空字符串忽略处理,如"     ".  
增加Ignore注解，忽略Javabean字段，不进行转换.  
用模板生成文件支持自定义起止标签.  
完善DB连接管理.  
加强代码质量.  
增强链式编程:Select,Update.  
调整bee.properties,HoneyConfig配置信息.  
整合Spring boot,提供bee-spring-boot-starter.  
支持利用Javabean生成表.  
修复多表分页查询时,同名字段在部分数据库会混淆的缺陷(oracle).  
修复缺陷:update默认主键为id时,无id字段或id为null时,异常处理.  
修复缺陷:cache bug.  
修复缺陷:有关GenId的 getRangeId(int sizeOfIds)方法.  
修复缺陷:jdk 11下,LoggerFactory在配置log4j2时,报错.  
强烈建议:使用视图时,声明视图不放缓存(因会产生脏数据).    

**V1.9.8**(2021中秋节)  
SuidRich增加4个方法:  
public <T> int save(T entity);  
public <T> int update(T oldEntity,T newEntity);  
public <T> String selectJson(T entity, String selectField);  
public <T> String selectJson(T entity, String selectField, int start, int size);  

MoreTable(多表查询):  
支持子表实体字段为List类型的多表关联查询.   
支持两个子表的join关联查询(inner join,right join, left join);  
支持一个子表里还有一个子表的关联查询.   
修复问题:当一个子表的属性都为null时,子表字段直接设置为null.   
注解 JoinTable添加方法:subClass()用于List类型字段的多表关联查询.   
Condition新增方法,用于在关联查询时的on表达式达到提前过滤数据:  
public Condition opOn(String field, Op Op, Object value);  

MapSuid(不用Javabean实体结构操作数据库):  
新增update,count,查询分页,新增和调整insert and insertAndReturnId.  
至此，MapSuid的select,update,insert,delete及分页功能已完备.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSql.  
add method count(MapSql mapSql),update(MapSql mapSql),insertAndReturnId(MapSql mapSql),support page in MapSuid.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSqlImpl.  
add method toUpdateSqlByMap ,toCountSqlByMap ,support page in MapSqlProcessor.  
add method count(MapSql mapSql),update(MapSql mapSql),support page in MapSuidImpl.  
MapSuidImpl change two different method:insert(MapSql mapSql) & insertAndReturnId(MapSql mapSql)  

PreparedSqlLib新增selectMapList方法.  
多数据源读写模式,支持不同类型数据源,方便数据库间转移数据.  
Logger: 两个方法支持有Throwable参数.  
sql输出日志支持logger不同级别输出设置.  
增加流的工具类StreamUtil.  
ObjectUtils增加一个方法: isTrue(Boolean b)  
增强检测字段合法性,包括MapSuid使用的字段.  
use LinkedHashMap in List&lt;Map> result for selectMapList(String sql).  
Condition支持condition.set("fieldName", null).  
selectJson支持通过配置将long转为string  
增强autoGenBean ,支持生成Json格式的SQL脚本(SQL Json Script).  
添加通用查询功能支持(简化后端复杂查询编程).  
增强多线程支持.  
可指定bee.properties所在路径.  
自动生成Javabean(GenBean)支持类型:JSON,TEXT.  

fix bug for ExecutableSql.  
transfer the the field of 'order by'.  
fix null bug in create() of ObjectCreatorFactory.  
fix bug for max column number(excel in bee-ext).  
fix bug about HoneyContext.  
fix bug about checkPackageByClass.  
fix bug about multi-thread safe in ConditionHelper.  

**V1.11**  
V1.11(**劳动节版**) 五一前更新到Maven  
各细分版本添加功能如下:  
  
V1.11.0.1.1(**2022新年版**)  
SuidRich增加方法:  
  public <T> long insertAndReturnId(T entity,IncludeType includeType);  
PreparedSql增加方法:  
  public <T> List<T> select(String sql,T returnType);  
增加声明主键支持:  
  add annotation PrimaryKey  
  MapSqlKey support PrimaryKey  
可用BF代替BeeFactoryHelper加快输入  
增强:读写模式配置信息去除空格  
fix a bug for naming transfer  

V1.11.0.2.1(**2022春节版**)  
拦截器、多租户  
add Interceptor,InterceptorChain  
add DefaultInterceptor,CommInterceptorChain,DefaultInterceptorChain  

V1.11.0.2.4(**2022北京冬奥会版**)  
二级缓存扩展支持  
Redis缓存支持  
add BeeExtCache,DefaultBeeExtCache  
add BeeExtRedisCache  

V1.11.0.2.15(**2022元宵节版**)  
添加注解:Datetime,Createtime,Updatetime;JustFetch  
添加Jndi数据源支持  
检测MapSqlKey的值  

V1.11.0.2.20(**荣耀**)  
multi-DS同时使用不同类型DB优化  
支持同时使用多种数据库(如同时使用Mysql,Oracle,SQL Server)  
PreparedSql(自定义sql),MapSuid:拦截器，多数据源支持  
Suid,PreparedSql,MapSuid支持设置数据源名称,获取拦截器链  
Suid,PreparedSql,MapSuid,MoreTable增加方法:setDataSourceName,getDataSourceName,getInterceptorChain  
增加注解:  
AnnotationHandler,AutoSetString自动设置字符值  
Desensitize,敏感信息模糊处理  
ReplaceInto,MySQL replace into转换  
MultiTenancy多租户  
BeforeReturnAnnotationHandler,AbstractDictI18nDefaultHandler  
Dict字典转化  
DictI18n多语言国际化字典转化  

V1.11.0.2.28  (**Special Day**)  
增加ShardingStruct为分库分表作准备  
Column列名与属性名映射扩展支持  
支持自定义TypeHandler,处理查询的ResultSet结果  
PreparedSql自定义sql支持多表查询,返回多表关联Javabean结构数据  
fixed bug:  
多表查询同一个实体自我关联查询禁止自我多次循环  

V1.11.0.3.8  (**Lady First**)  
增加SetParaTypeConvert转化PreparedStatement参数.  
Javabean使用java.util.Date类型,进行SUID作兼容处理.  
SQLite获取Timestamp结果作转化处理.  
实体属性是Javabean与DB表Json类型字段在参数设置与查询结果时自动转换(使用Json注解自定义实现).  

V1.11.0.3.12  (**植树节版**)  
Ddl.java使用Javabean创建表,支持追加java与db字段类型映射,支持设置某个DB的java_dbtype类型映射.  
Ddl.java兼容原生char类型,兼容java.util.Date.  
PreparedSql自定义sql支持批量插入.  
支持在Suid等对象设置命名转换器.  
增加DbFeature方言注册器,自定义实现不同DB方言更加易用.  
支持Cassandra.  
showExecutableSql添加List,Set,Map,UUID支持.  

V1.11.0.3.20  (**春分**)  
自定义动态SQL标签,@in,@toIsNULL1,@toIsNULL2,&lt;if isNotNull>,&lt;if isNotBlank>.  
动态sql,将list转为像in (1,2,3)的语句,不需要foreach,批量插入也不需要foreach.  
分离中文API.  

V1.11.0.4.22 (**世界地球日**)  
增加Registry空接口；增加NameRegistry.  
更改Serializer接口抛出异常方式.  
MapSuid,MapSql支持解析字符串的Boolean类型.  
GenBean，还不支持的jdbc类型，提醒在哪个文件设置.  
GenBean增加支持是否覆盖原有文件设置.  
GenBean增加获取字段支持，使用字段名可以不直接使用字符串.  
SuidRich的selectString方法支持可变参数:  
 public <T> List<String[]> selectString(T entity,String... selectFields);  
CommInterceptorChain增加检测是否添加了相同类型拦截器.  
systemLogger支持设置日志级别，方便开发调试.  
Logger增加public static void debug(String msg,Throwable t)(方便开发调试).  
nocache增加日志提示.  
提高缓存安全.  
添加SPI预加载接口PreLoad.  
添加用于全局的拦截器注册器InterceptorChainRegistry.  
添加配置项:  
是否是limit offset语法分页 pagingWithLimitOffset  
是否捕获单条插入时的重复键异常 notCatchModifyDuplicateException  
是否显示单条插入时的重复键异常 notShowModifyDuplicateException  
fixed bug for type converter.  
fixed bug about @PrimaryKey in Suid update(entity).  

V1.11.0.4.29  
配置文件支持多环境差异化配置.  
SuidRich,public <T> int update(T oldEntity, T newEntity)拦截器只处理新实体newEntity.  

**V1.11** (**International Labour Day**)  
功能汇总列表:  
1)拦截器、多租户  
2)增加ShardingStruct为分库分表作准备  
3)二级缓存扩展支持  
Redis缓存支持  
4)支持自定义TypeHandler,处理查询的ResultSet结果  
     添加转换器SetParaTypeConvert转换PreparedStatement参数的类型  
5)支持在Suid等对象设置命名转换器.  
增加DbFeature方言注册器,自定义实现不同DB方言更加易用.  
6)支持Cassandra.  
7)添加Jndi数据源支持  
8)Ddl.java使用Javabean创建表,支持追加java与db字段类型映射,支持设置某个DB的java_dbtype类型映射.  
9)PreparedSql自定义sql支持批量插入.  
PreparedSql自定义sql支持多表查询,返回多表关联Javabean结构数据  
10)自定义动态SQL标签,@in,@toIsNULL1,@toIsNULL2,<if isNotNull>,<if isNotBlank>.  
动态sql,将list转为像in (1,2,3)的语句,不需要foreach,批量插入也不需要foreach.  
11)注册器:  
CalculateRegistry,计算分片算法注册器  
DbFeatureRegistry,DB方言特性注册器  
InterceptorChainRegistry,拦截器链注册器  
NameRegistry,命名转换注册器  
SetParaTypeConverterRegistry, PreparedStatement参数类型转换注册器  
TypeHandlerRegistry 查询结果转换处理注册器  
12)配置文件支持多环境差异化配置.  
  
添加注解:  
PrimaryKey,Datetime,Createtime,Updatetime;JustFetch  
AnnotationHandler,AutoSetString自动设置字符值  
Desensitize,敏感信息模糊处理  
ReplaceInto,MySQL replace into转换  
MultiTenancy多租户  
BeforeReturnAnnotationHandler,AbstractDictI18nDefaultHandler  
Dict字典转化  
DictI18n多语言国际化字典转化  
Column列名与属性名映射扩展支持  
  
增强:  
multi-DS同时使用不同类型DB优化  
 (比如,同时使用Mysql,Oracle,SQL Server)  
可用BF代替BeeFactoryHelper加快输入  
Javabean使用java.util.Date类型,进行SUID作兼容处理.  
Ddl.java兼容原生char类型,兼容java.util.Date.
SQLite获取Timestamp结果作转化处理.  
实体属性是Javabean与DB表Json类型字段在参数设置与查询结果时自动转换(使用Json注解自定义实现).
读写模式配置信息去除空格  
检测MapSqlKey的值  
增加Registry空接口；增加NameRegistry.  
更改Serializer接口抛出异常方式.  
MapSuid,MapSql支持解析字符串的Boolean类型.  
GenBean，还不支持的jdbc类型，提醒在哪个文件设置.  
GenBean增加支持是否覆盖原有文件设置.  
GenBean增加获取字段支持，使用字段名可以不直接使用字符串.  
SuidRich的selectString方法支持可变参数:  
public List<String[]> selectString(T entity,String... selectFields);  
CommInterceptorChain增加检测是否添加了相同类型拦截器.  
提高缓存安全.  
添加SPI预加载接口PreLoad.  
添加用于全局的拦截器注册器InterceptorChainRegistry.  
SuidRich,public <T> int update(T oldEntity, T newEntity)拦截器只处理新实体newEntity.  

fixed bug:  
naming transfer  
多表查询同一个实体自我关联查询禁止自我多次循环  

**V1.17(2022·中秋)**  
**新增功能**:  
1)SqlServer支持start,size两个参数分页  
2)事务注解Tran及提供与AOP协调的默认实现;支持在类级别使用  
3)**支持Android(安卓)直接使用Bee访问SQLite数据库;Bee增加Android ORM功能.**  
4)**支持HarmonyOS(鸿蒙)直接使用Bee访问SQLite数据库;Bee增加HarmonyOS ORM功能.** 
在**Harmony和Android两个环境**,可以用**同一套Bee代码访问DB**,提高代码重用,节省人力物力!  
5)支持Android日志:android.util.Log  
6)支持HarmonyOS日志:ohos.hiviewdfx.HiLog  

7)主键支持名称不叫"id",类型除了Long,可以是Integer或String  
8)支持用注解定义主键自动生成,主键值生成注解:GenId,GenUUID  
9)@Column添加默认实现(强烈建议:在新系统中不要使用该注解)  
10)@Table,@Column,@PrimaryKey(@Id),@Ignore(@Transient)可以兼容JPA相应注解(在AnnoAdapter接口定义)  
11)字段名称引用类(默认格式:实体名_F(自动生成))增加ALL_NAMES属性,可一次获取实体的所有字段值  
12)Ddl.java支持创建索引(normal,unique),联合主键  
13)动态获取JdbcToJavaType  
14)命名转换增加种类4(DbUpperAndJavaLower):数据库使用大写字母，Java使用小写字母;忽略大小写,使用的字符是一样的  
15)多种命名时,缓存添加TranslateType部分  
16)分布式id生成器,支持设置起始年份:bee.distribution.genid.startYear  

**优化与增强:**  
1)增强:GenBean生成Javabean,当id是BigDecimal时,重置为Long型  
2)优化GenBean,支持都使用默认配置  
3)Ddl: 优化创建表流程  
4)多数据源环境下,增加日志提示当前使用的是哪个数据源名称  
5)分页查询,当获取一页的数据量size为0时,直接返回emptyList  
6)增强:SQLite日期类型 (date) 匹配转换支持  
7)优化缓存  
8)condition.op(fieldName, Op.in, Value)增加支持List,Set,Number Array,单个Number元素  
9)condition.opOn(fieldName, Op.in, Value) Value限定只支持Number和String  
10)增强:like;Op添加likeLeft,likeRight,likeLeftRight(参数值由框架负责转义);打印SQL日志作相应转义  
11)增强:ExcelReader数据列数目动态计算  
12)增强:SQLite日期类型 (date) 匹配转换支持  
13)链式编程SelectImpl,UpdateImpl调整字段检测.  

fixed bug:
1)level 2缓存判断;TypeHandlerRegistry返回值类型转换   
2)拦截器对象不使用原型模式产生脏数据,改为原型模式   

**V1.17.0.10(查漏补缺)**  
fixed bug:
1)拦截器对象不使用原型模式产生脏数据,改为原型模式  
2)Android获取连接对象是已关闭的,要重新获取  

**V1.17.0.9(精益求精·七夕)**  
1)事务注解@Tran,支持在类级别使用  
2)字段名称引用类(默认格式:实体名_F(自动生成))增加ALL_NAMES属性,可一次获取实体的所有字段值  
3)Ddl.java支持创建索引(normal,unique),联合主键  
4)动态获取JdbcToJavaType  
5)命名转换增加种类4(DbUpperAndJavaLower):数据库使用大写字母，Java使用小写字母;忽略大小写,使用的字符是一样的  
6)多种命名时,缓存添加TranslateType部分  
7)@Ignore(@Transient)可以兼容JPA相应注解(在AnnoAdapter接口定义)  
8)condition.op(fieldName, Op.in, Value)增加支持List,Set,Number Array,单个Number元素  
9)condition.opOn(fieldName, Op.in, Value) Value限定只支持Number和String  
10)增强:like;Op添加likeLeft,likeRight,likeLeftRight(参数值由框架负责转义);打印SQL日志作相应转义  
11)增强:ExcelReader数据列数目动态计算  
12)增强:SQLite日期类型 (date) 匹配转换支持  
13)增强:GenBean生成Javabean,当id是BigDecimal时,重置为Long型  	
14)fixed bug:level 2缓存判断;TypeHandlerRegistry返回值类型转换   

**V1.17.0.8(海纳百川)**  
1)主键支持名称不叫"id",类型除了Long,可以是Integer或String  
2)支持用注解定义主键自动生成,主键值生成注解:GenId,GenUUID  
3)@Column添加默认实现(强烈建议:在新系统中不要使用该注解)  
4)@Table,@Column,@PrimaryKey(@Id)可以兼容JPA相应注解(在AnnoAdapter接口定义)  
5)分布式id生成器,支持设置起始年份:bee.distribution.genid.startYear  
6)链式编程SelectImpl,UpdateImpl调整字段检测.  

**V1.17.0.7(有为)**  
1)**支持HarmonyOS(鸿蒙)直接使用Bee访问SQLite数据库;**  
2)在**Harmony和Android两个环境**,可以用**同一套Bee代码访问DB**,提高代码重用,节省人力物力!  
3)支持HarmonyOS日志:ohos.hiviewdfx.HiLog  

**V1.17.0.6(奋斗)**  
1)**支持Android(安卓)系统直接使用Bee访问SQLite数据库;Bee增加Android ORM功能.**  
2)支持Android日志:android.util.Log  
3)Ddl: 优化创建表流程  
4)多数据源环境下,增加日志提示当前使用的是哪个数据源名称  
5)分页查询,当获取一页的数据量size为0时,直接返回emptyList  
6)优化GenBean,支持都使用默认配置  
7)优化缓存  

**V1.17.0.5(日臻完善)**  
1)SqlServer支持start,size两个参数分页  
2)事务注解Tran  


	
	