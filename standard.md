## Java后端

 【强制】表必备三字段：id, create_time, update_time。 



9.【强制】POJO 类中的任何布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。

POJO 类中的变量，不要以大写开头。否则序列化可能失败。



19.【参考】各层命名规约：

A) Service/DAO 层方法命名规约

1） 获取单个对象的方法用 get 做前缀。

2） 获取多个对象的方法用 list 做前缀，复数结尾，如：listObjects。

3） 获取统计值的方法用 count 做前缀。

4） 插入的方法用 save/insert 做前缀。

5） 删除的方法用 remove/delete 做前缀。

6） 修改的方法用 update 做前缀。

B) 领域模型命名规约

1） 数据对象：xxxDO，xxx 即为数据表名。

2） 数据传输对象：xxxDTO，xxx 为业务领域相关的名称。

3） 展示对象：xxxVO，xxx 一般为网页名称。

4） POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO。



6【强制】Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。

正例："test".equals(object);

反例：object.equals("test");

说明：推荐使用 JDK7 引入的工具类 java.util.Objects#equals(Object a, Object b)



1） 【强制】所有的 POJO 类属性必须使用**包装数据类型。**

2） 【强制】RPC 方法的返回值和参数必须使用**包装数据类型。**



14.【强制】定义 DO/DTO/VO 等 POJO 类时，不要设定任何属性默认值。



6.【强制】使用 Map 的方法 keySet()/values()/entrySet()返回集合对象时，不可以对其进行添

加元素操作，否则会抛出 UnsupportedOperationException 异常。(List集合同理)



17.【推荐】集合初始化时，指定集合初始值大小。



7【强制】在高并发场景中，避免使用”等于”判断作为中断或退出的条件。



5.【强制】在日志输出时，字符串变量之间的拼接使用占位符的方式。

说明：因为 String 字符串的拼接会使用 StringBuilder 的 append()方式，有一定的性能损耗。使用占位符仅是替换动作，可以有效提升性能。



【参考】分层领域模型规约：

DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。

DTO（Data Transfer Object）：数据传输对象，Service 或 Manager 向外传输的对象。

BO（Business Object）：业务对象，可以由 Service 层输出的封装业务逻辑的对象。

Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类

来传输。

VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。



3.【推荐】给 JVM 环境参数设置-XX:+HeapDumpOnOutOfMemoryError 参数，让 JVM 碰到 OOM场景时输出 dump 信息。







## 前端

URL 路径不能使用大写，单词如果需要分隔，统一使用下划线。

3） 请求方法：对具体操作的定义，常见的请求方法如下：

a） GET：从服务器取出资源。

b） POST：在服务器新建一个资源。

c） PUT：在服务器更新资源。

d） DELETE：从服务器删除资源。

4） 请求内容：URL 带的参数必须无敏



【强制】前后端数据列表相关的接口返回，如果为空，则返回空数组[]或空集合{}。



【强制】在前后端交互的JSON格式数据中，所有的key必须为小写字母开始的lowerCamelCase风格，符合英文表达习惯，且表意完整。



【强制】对于需要使用超大整数的场景，服务端一律使用 String 字符串类型返回，禁止使用Long 类型。



7【强制】HTTP 请求通过 URL 传递参数时，不能超过 2048 字节。



【强制】在翻页场景中，用户输入参数的小于1，则前端返回第一页参数给后端；后端发现用户输入的参数大于总页数，直接返回最后一页。



- 明确空值的意义。比如在做更新操作时，空值是表示重置，还是忽略更新