

> 参考 阿里巴巴Java开发手册_嵩山版_20200803，摘抄部分有代表性的规范



# 编程规约

## (一) 命名风格

【强制】类名使用 UpperCamelCase 风格，但以下情形例外：DO / BO / DTO / VO / AO / 

PO / UID 等。

正例：ForceCode / UserDO / HtmlDTO / XmlService / TcpUdpDeal / TaPromotion



【强制】方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格。

正例： localValue / getHttpMessage() / inputUserId



【强制】常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。

正例：MAX_STOCK_COUNT / CACHE_EXPIRED_TIME



【强制】抽象类命名使用 Abstract 或 Base 开头；异常类命名使用 Exception 结尾；测试类命名以它要测试的类的名称开始，以 Test 结尾。



【强制】类型与中括号紧挨相连来表示数组。

正例：定义整形数组 int[] arrayDemo。



【强制】POJO 类中的任何布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误



【强制】杜绝完全不规范的缩写，避免望文不知义。

反例：AbstractClass“缩写”成 AbsClass；condition“缩写”成 condi；Function 缩写”成 Fu，此类

随意缩写严重降低了代码的可阅读性。



【推荐】在常量与变量的命名时，表示类型的名词放在词尾，以提升辨识度。

正例：startTime / workQueue / nameList / TERMINATED_THREAD_COUNT



【推荐】如果模块、接口、类、方法使用了设计模式，在命名时需体现出具体模式。

说明：将设计模式体现在名字中，有利于阅读者快速理解架构设计理念。

正例： public class OrderFactory;

 public class LoginProxy;

 public class ResourceObserver;



【推荐】接口类中的方法和属性不要加任何修饰符号（public 也不要加），保持代码的简洁性，并加上有效的 Javadoc 注释。尽量不要在接口里定义变量，如果一定要定义变量，确定与接口方法相关，并且是整个应用的基础常量。

正例：接口方法签名 void commit();

 接口基础常量 String COMPANY = "alibaba";



接口和实现类的命名有两套规则：

1）【强制】对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部的实现类用

Impl 的后缀与接口区别。

正例：CacheServiceImpl 实现 CacheService 接口。



【参考】枚举类名带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。

说明：枚举其实就是特殊的常量类，且构造方法被默认强制是私有。

正例：枚举名字为 ProcessStatusEnum 的成员名称：SUCCESS / UNKNOWN_REASON。



【参考】各层命名规约：

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



【强制】不允许任何魔法值（即未经预先定义的常量）直接出现在代码中。



## (二) 常量定义

【强制】不允许任何魔法值（即未经预先定义的常量）直接出现在代码中。



【强制】在 long 或者 Long 赋值时，数值后使用大写字母 L，不能是小写字母 l，小写容易跟数字混淆，造成误解。



【推荐】不要使用一个常量类维护所有常量，要按常量功能进行归类，分开维护。



## (三) 代码格式

【强制】采用 4 个空格缩进，禁止使用 Tab 字符。



【强制】注释的双斜线与注释内容之间有且仅有一个空格。



【强制】单行字符数限制不超过 120 个，超出需要换行，换行时遵循如下原则超过 120 个字符的情况下，换行缩进 4 个空格，并且方法前的点号一起换行



【强制】IDE 的 text file encoding 设置为 UTF-8; IDE 中文件的换行符使用 Unix 格式，不要使用 Windows 格式。



【推荐】不同逻辑、不同语义、不同业务的代码之间插入一个空行分隔开来以提升可读性。

说明：任何情形，没有必要插入多个空行进行隔开。





## (四) OOP 规约

【强制】外部正在调用或者二方库依赖的接口，不允许修改方法签名，避免对接口调用方产生影响。接口过时必须加@Deprecated 注解，并清晰地说明采用的新接口或者新服务是什么。



【强制】Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。

正例："test".equals(object);



【强制】所有整型包装类对象之间值的比较，全部使用 equals 方法比较。



【强制】浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals来判断。



【强制】如上所示 BigDecimal 的等值比较应使用 compareTo()方法，而不是 equals()方法。

说明：equals()方法会比较值和精度（1.0 与 1.00 返回结果为 false），而 compareTo()则会忽略精度。



【强制】禁止使用构造方法 BigDecimal(double)的方式把 double 值转化为 BigDecimal 对象。



关于基本数据类型与包装数据类型的使用标准如下：

1） 【强制】所有的 POJO 类属性必须使用包装数据类型。

2） 【强制】RPC 方法的返回值和参数必须使用包装数据类型。



【强制】定义 DO/DTO/VO 等 POJO 类时，不要设定任何属性默认值



【强制】序列化类新增属性时，请不要修改 serialVersionUID 字段，避免反序列失败；如果

完全不兼容升级，避免反序列化混乱，那么请修改 serialVersionUID 值。



【强制】构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init 方法中。



【强制】禁止在 POJO 类中，同时存在对应属性 xxx 的 isXxx()和 getXxx()方法。(BOOlean和boolean，是有is和get的区别)



【推荐】使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无内容的检查，否则会有抛 IndexOutOfBoundsException 的风险。



【推荐】循环体内，字符串的连接方式，使用 StringBuilder 的 append 方法进行扩展。





## (五) 日期时间

【强制】日期格式化时，传入 pattern 中表示年份统一使用小写的 y。



【强制】在日期格式中分清楚大写的 M 和小写的 m，大写的 H 和小写的 h 分别指代的意义。

说明：日期格式中的这两对字母表意如下：

1） 表示月份是大写的 M； 

2） 表示分钟则是小写的 m； 

3） 24 小时制的是大写的 H； 

4） 12 小时制的则是小写的 h。



【强制】获取当前毫秒数：System.currentTimeMillis(); 而不是 new Date().getTime()。

说明：如果想获取更加精确的纳秒级时间值，使用 System.nanoTime 的方式。在 JDK8 中，针对统计时间

等场景，推荐使用 Instant 类。



【强制】不允许在程序任何地方中使用：1）java.sql.Date。 2）java.sql.Time。 

3）java.sql.Timestamp。



【推荐】避免公历闰年 2 月问题。闰年的 2 月份有 29 天，一年后的那一天不可能是 2 月 29

日。



【推荐】使用枚举值来指代月份。如果使用数字，注意 Date，Calendar 等日期相关类的月份month 取值在 0-11 之间。

说明：参考 JDK 原生注释，Month value is 0-based. e.g., 0 for January.

正例： Calendar.JANUARY，Calendar.FEBRUARY，Calendar.MARCH 等来指代相应月份来进行传参或

比较。



## (六) 集合处理

【强制】判断所有集合内部的元素是否为空，使用 isEmpty()方法，而不是 size()==0 的方式。

说明：在某些集合中，前者的时间复杂度为 O(1)，而且可读性更好。



【强制】ArrayList 的 subList 结果不可强转成 ArrayList，否则会抛出 ClassCastException 异 

常：java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。



【强制】使用 Map 的方法 keySet()/values()/entrySet()返回集合对象时，不可以对其进行添加元素操作，否则会抛出 UnsupportedOperationException 异常。



【强制】在使用 Collection 接口任何实现类的 addAll()方法时，都要对输入的集合参数进行NPE 判断。

说明：在 ArrayList#addAll 方法的第一行代码即 Object[] a = c.toArray(); 其中 c 为输入集合参数，如果

为 null，则直接抛出异常。



【强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。



【强制】泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add 方法， 而<? super T>不能使用 get 方法，两者在接口调用赋值的场景中容易出错。

说明：扩展说一下 PECS(Producer Extends Consumer Super)原则：第一、频繁往外读取内容的，适合用

<? extends T>。第二、经常往里插入的，适合用<? super T>



【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator方式，如果并发操作，需要对 Iterator 对象加锁。



【推荐】集合泛型定义时，在 JDK7 及以上，使用 diamond 语法或全省略。

说明：菱形泛型，即 diamond，直接使用<>来指代前边已经指定的类型。



【推荐】集合初始化时，指定集合初始值大小。



【推荐】使用 entrySet 遍历 Map 类集合 KV，而不是 keySet 方式进行遍历。



【参考】合理利用好集合的有序性(sort)和稳定性(order)，避免集合的无序性(unsort)和不稳定性(unorder)带来的负面影响。

说明：有序性是指遍历的结果是按某种比较规则依次排列的。稳定性指集合每次遍历的元素次序是一定的。

如：ArrayList 是 order/unsort；HashMap 是 unorder/unsort；TreeSet 是 order/sort。



【参考】利用 Set 元素唯一的特性，可以快速对一个集合进行去重操作，避免使用 List 的contains()进行遍历去重或者判断包含操作。



## (七) 并发处理

【强制】获取单例对象需要保证线程安全，其中的方法也要保证线程安全。

说明：资源驱动类、工具类、单例工厂类都需要注意。

 

【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。



【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。



【强制】必须回收自定义的 ThreadLocal 变量，尤其在线程池场景下，线程经常会被复用，如果不清理自定义的 ThreadLocal 变量，可能会影响后续业务逻辑和造成内存泄露等问题。尽量在代理中使用 try-finally 块进行回收。



【强制】高并发时，同步调用应该去考量锁的性能损耗。能用无锁数据结构，就不要用锁；能锁区块，就不要锁整个方法体；能用对象锁，就不要用类锁。



【强制】在使用阻塞等待获取锁的方式中，必须在 try 代码块之外，并且在加锁方法与 try 代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在 finally 中无法解锁。

```
正例：
Lock lock = new XxxLock();
// ...
lock.lock();
try {
 doSomething();
 doOthers();
} finally {
 lock.unlock();
```



【强制】在使用尝试机制来获取锁的方式中，进入业务代码块之前，必须先判断当前线程是否持有锁。锁的释放规则与锁的阻塞等待方式相同。

说明：Lock 对象的 unlock 方法在执行时，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），如果

当前线程不持有锁，则抛出 IllegalMonitorStateException 异常。

```
正例：

Lock lock = new XxxLock();

// ...

boolean isLocked = lock.tryLock();

if (isLocked) {

 try {

 doSomething();

 doOthers();

 } finally {

 lock.unlock();

 } 

}
```



【强制】并发修改同一记录时，避免更新丢失，需要加锁。要么在应用层加锁，要么在缓存加锁，要么在数据库层使用乐观锁，使用 version 作为更新依据。

说明：如果每次访问冲突概率小于 20%，推荐使用乐观锁，否则使用悲观锁。乐观锁的重试次数不得小于

3 次。



【推荐】资金相关的金融敏感信息，使用悲观锁策略。

说明：乐观锁在获得锁的同时已经完成了更新操作，校验逻辑容易出现漏洞，另外，乐观锁对冲突的解决策

略有较复杂的要求，处理不当容易造成系统压力或数据异常，所以资金相关的金融敏感信息不建议使用乐观

锁更新。

正例：悲观锁遵循一锁、二判、三更新、四释放的原则



【推荐】使用 CountDownLatch 进行异步转同步操作，每个线程退出前必须调用 countDown 方法，线程执行代码注意 catch 异常，确保 countDown 方法被执行到，避免主线程无法执行至await 方法，直到超时才返回结果。

说明：注意，子线程抛出异常堆栈，不能在主线程 try-catch 到。



说明：Random 实例包括 java.util.Random 的实例或者 Math.random()的方式。



【推荐】通过双重检查锁（double-checked locking）（在并发场景下）存在延迟初始化的优化问题隐患（可参考 The "Double-Checked Locking is Broken" Declaration），推荐解决方案中较为简单一种（适用于 JDK5 及以上版本），将目标属性声明为 volatile 型，比如将 helper 的属性声明修改为`private volatile Helper helper = null;`。

```
正例：
public class LazyInitDemo {
 private volatile Helper helper = null;
 public Helper getHelper() {
 if (helper == null) {
 synchronized (this) {
 if (helper == null) { helper = new Helper(); }
 }
 }
 return helper;
 }
 // other methods and fields... 
}
```



【参考】volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，但是如果多写，同样无法解决线程安全问题。

说明：如果是 count++操作，使用如下类实现：AtomicInteger count = new AtomicInteger(); 

count.addAndGet(1); 如果是 JDK8，推荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观

锁的重试次数）。



【参考】HashMap 在容量不够进行 resize 时由于高并发可能出现死链，导致 CPU 飙升，在

开发过程中注意规避此风险。初始化符合需求的容量



【参考】ThreadLocal 对象使用 static 修饰，ThreadLocal 无法解决共享对象的更新问题。

说明：这个变量是针对一个线程内所有操作共享的，所以设置为静态变量，所有此类实例共享此静态变量，

也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只要是这个线程内定义的)都可

以操控这个变量。



## (八) 控制语句

【强制】在一个 switch 块内，每个 case 要么通过 continue/break/return 等来终止，要么注释说明程序将继续执行到哪一个 case 为止；在一个 switch 块内，必须包含一个 default语句并且放在最后，即使它什么代码也没有。

说明：注意 break 是退出 switch 语句块，而 return 是退出方法体。



【强制】当 switch 括号内的变量类型为 String 并且此变量为外部参数时，必须先进行 null判断。



 

【强制】在 if/else/for/while/do 语句中必须使用大括号。

说明：即使只有一行代码，也禁止不采用大括号的编码方式：if (condition) statements; 



【强制】在高并发场景中，避免使用”等于”判断作为中断或退出的条件。

说明：如果并发控制没有处理好，容易产生等值判断被“击穿”的情况，使用大于或小于的区间判断条件来代替。



【推荐】表达异常的分支时，少用 if-else 方式，这种方式可以改写成：

```
if (condition) { 

 ...

 return obj; 

}

// 接着写 else 的业务逻辑代码; 

正例：超过 3 层的 if-else 的逻辑判断代码可以使用卫语句、策略模式、状态模式等来实现，其中卫语句

public void findBoyfriend (Man man) {
 if (man.isUgly()) {
 System.out.println("本姑娘是外貌协会的资深会员");
 return;
 }
 if (man.isPoor()) {
 System.out.println("贫贱夫妻百事哀");
 return;
 }
 if (man.isBadTemper()) {
 System.out.println("银河有多远，你就给我滚多远");
 return; }
 System.out.println("可以先交往一段时间看看");
}

```



【推荐】除常用方法（如 getXxx/isXxx）等外，不要在条件判断中执行其它复杂的语句，将复杂逻辑判断的结果赋值给一个有意义的布尔变量名，以提高可读性。

说明：很多 if 语句内的逻辑表达式相当复杂，与、或、取反混合运算，甚至各种方法纵深调用，理解成本非常高。如果赋值一个非常好理解的布尔变量名字，则是件令人爽心悦目的事情。

```
正例：
// 伪代码如下
final boolean existed = (file.open(fileName, "w") != null) && (...) || (...);
if (existed) {
 ...
}
反例：
public final void acquire ( long arg) {
 if (!tryAcquire(arg) &&
 acquireQueued(addWaiter(Node.EXCLUSIVE), arg)) {
 selfInterrupt();
 }
```



【推荐】不要在其它表达式（尤其是条件表达式）中，插入赋值语句。



【推荐】循环体中的语句要考量性能，以下操作尽量移至循环体外处理，如定义对象、变量、获取数据库连接，进行不必要的 try-catch 操作（这个 try-catch 是否可以移至循环体外）。



【推荐】避免采用取反逻辑运算符。

说明：取反逻辑不利于快速理解，并且取反逻辑写法一般都存在对应的正向逻辑写法。

正例：使用 if (x < 628) 来表达 x 小于 628。

反例：使用 if (!(x >= 628)) 来表达 x 小于 628。



【推荐】公开接口需要进行入参保护，尤其是批量操作的接口。

反例：某业务系统，提供一个用户批量查询的接口，API 文档上有说最多查多少个，但接口实现上没做任何保护，导致调用方传了一个 1000 的用户 id 数组过来后，查询信息后，内存爆了。



【参考】下列情形，不需要进行参数校验： 

1） 极有可能被循环调用的方法。但在方法说明里必须注明外部参数检查。

2） 底层调用频度比较高的方法。毕竟是像纯净水过滤的最后一道，参数错误不太可能到底层才会暴露问题。一般 DAO 层与 Service 层都在同一个应用中，部署在同一台服务器中，所以 DAO 的参数校验，可以省略。

3） 被声明成 private 只会被自己代码所调用的方法，如果能够确定调用方法的代码传入参数已经做过检查或者肯定不会有问题，此时可以不校验参数。



## (九) 注释规约

【强制】类、类属性、类方法的注释必须使用 Javadoc 规范，使用/**内容*/格式，不得使用// xxx 方式。



【强制】所有的类都必须添加创建者和创建日期



【强制】方法内部单行注释，在被注释语句上方另起一行，使用//注释。方法内部多行注释使用/* */注释，注意与代码对齐。



【强制】所有的枚举类型字段必须要有注释，说明每个数据项的用途。



【推荐】代码修改的同时，注释也要进行相应的修改，尤其是参数、返回值、异常、核心逻辑等的修改。

说明：代码与注释更新不同步，就像路网与导航软件更新不同步一样，如果导航软件严重滞后，就失去了导航的意义。



【推荐】在类中删除未使用的任何字段、方法、内部类；在方法中删除未使用的任何参数声明与内部变量。



【参考】特殊注释标记，请注明标记人与标记时间。注意及时处理这些标记，通过标记扫描，经常清理此类标记。线上故障有时候就是来源于这些标记处的代码。

1） 待办事宜（TODO）:（标记人，标记时间，[预计处理时间]）

表示需要实现，但目前还未实现的功能。这实际上是一个 Javadoc 的标签，目前的 Javadoc 还没有实现，但已经被广泛使用。只能应用于类，接口和方法（因为它是一个 Javadoc 标签）。

2） 错误，不能工作（FIXME）:（标记人，标记时间，[预计处理时间]）

在注释中用 FIXME 标记某代码是错误的，而且不能工作，需要及时纠正的情况。



## (十) 前后端规约

【强制】前后端交互的 API，需要明确协议、域名、路径、请求方法、请求内容、状态码、响应体。

说明：

1） 协议：生产环境必须使用 HTTPS。 

2） 路径：每一个 API 需对应一个路径，表示 API 具体的请求地址：

a） 代表一种资源，只能为名词，推荐使用复数，不能为动词，请求方法已经表达动作意义。

b） URL 路径不能使用大写，单词如果需要分隔，统一使用下划线。

c） 路径禁止携带表示请求内容类型的后缀，比如".json",".xml"，通过 accept 头表达即可。

3） 请求方法：对具体操作的定义，常见的请求方法如下：

a） GET：从服务器取出资源。

b） POST：在服务器新建一个资源。

c） PUT：在服务器更新资源。

d） DELETE：从服务器删除资源。

4） 请求内容：URL 带的参数必须无敏感信息或符合安全要求；body 里带参数时必须设置 Content-Type。 

5） 响应体：响应体 body 可放置多种数据类型，由 Content-Type 头来确定。



【强制】前后端数据列表相关的接口返回，如果为空，则返回空数组[]或空集合{}。

说明：此条约定有利于数据层面上的协作更加高效，减少前端很多琐碎的 null 判断。



【强制】服务端发生错误时，返回给前端的响应信息必须包含 HTTP 状态码，errorCode、

errorMessage、用户提示信息四个部分。



【强制】在前后端交互的 JSON 格式数据中，所有的 key 必须为小写字母开始的lowerCamelCase 风格，符合英文表达习惯，且表意完整。

正例：errorCode / errorMessage / assetStatus / menuList / orderList / configFlag



【强制】对于需要使用超大整数的场景，服务端一律使用 String 字符串类型返回，禁止使用Long 类型。



【强制】HTTP 请求通过 URL 传递参数时，不能超过 2048 字节。



【强制】HTTP 请求通过 body 传递内容时，必须控制长度，超出最大长度后，后端解析会出错。

说明：nginx 默认限制是 1MB，tomcat 默认限制为 2MB，当确实有业务需要传较大内容时，可以通过调大服务器端的限制。



【强制】在翻页场景中，用户输入参数的小于 1，则前端返回第一页参数给后端；后端发现用户输入的参数大于总页数，直接返回最后一页。



【强制】服务器内部重定向必须使用 forward；外部重定向地址必须使用 URL 统一代理模块生成，否则会因线上采用 HTTPS 协议而导致浏览器提示“不安全”，并且还会带来 URL 维护不一致的问题。



【推荐】服务端返回的数据，使用 JSON 格式而非 XML。



【推荐】前后端的时间格式统一为"yyyy-MM-dd HH:mm:ss"，统一为 GMT。



【参考】在接口路径中不要加入版本号，版本控制在 HTTP 头信息中体现，有利于向前兼容。

说明：当用户在低版本与高版本之间反复切换工作时，会导致迁移复杂度升高，存在数据错乱风险。



## (十一) 其他

【强制】避免用 Apache Beanutils 进行属性的 copy。

说明：Apache BeanUtils 性能较差，可以使用其他方案比如 Spring BeanUtils, Cglib BeanCopier，注意均是浅拷贝。



【强制】注意 Math.random() 这个方法返回是 double 类型，注意取值的范围 0≤x<1（能够取到零值，注意除零异常），如果想获取整数类型的随机数，不要将 x 放大 10 的若干倍然后取整，直接使用 Random 对象的 nextInt 或者 nextLong 方法。



【推荐】及时清理不再使用的代码段或配置信息。



# 二、异常日志

## (一) 错误码

【强制】错误码不体现版本号和错误等级信息。

说明：错误码以不断追加的方式进行兼容。错误等级由日志和错误码本身的释义来决定。



【强制】错误码为字符串类型，共 5 位，分成两个部分：错误产生来源+四位数字编号。

说明：错误产生来源分为 A/B/C，A 表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付超时等问题；B 表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；C 表示错误来源于第三方服务，比如 CDN 服务出错，消息投递超时等问题；四位数字编号从 0001 到 9999，大类之间的步长间距预留 100，参考文末**附表 3**。



【强制】编号不与公司业务架构，更不与组织架构挂钩，以先到先得的原则在统一平台上进行，审批生效，编号即被永久固定。



【强制】错误码不能直接输出给用户作为提示信息使用。

说明：堆栈（stack_trace）、错误信息(error_message)、错误码（error_code）、提示信息（user_tip）是一个有效关联并互相转义的和谐整体，但是请勿互相越俎代庖。



【参考】错误码分为一级宏观错误码、二级宏观错误码、三级宏观错误码。

说明：在无法更加具体确定的错误场景中，可以直接使用一级宏观错误码，分别是：A0001（用户端错误）、B0001（系统执行出错）、C0001（调用第三方服务出错）。

正例：调用第三方服务出错是一级，中间件错误是二级，消息服务出错是三级。



## (二) 异常处理

【强制】Java 类库中定义的可以通过预检查方式规避的 RuntimeException 异常不应该通过catch 的方式来处理，比如：NullPointerException，IndexOutOfBoundsException 等等。

说明：无法通过预检查的异常除外，比如，在解析字符串形式的数字时，可能存在数字格式错误，不得不通过 catch NumberFormatException 来实现。

正例：if (obj != null) {...}

反例：try { obj.method(); } catch (NullPointerException e) {…}



 

【强制】异常捕获后不要用来做流程控制，条件控制。

说明：异常设计的初衷是解决程序运行中的各种意外情况，且异常的处理效率比条件判断方式要低很多。



【强制】catch 时请分清稳定代码和非稳定代码，稳定代码指的是无论如何不会出错的代码。对于非稳定代码的 catch 尽可能进行区分异常类型，再做对应的异常处理。

说明：对大段代码进行 try-catch，使程序无法根据不同的异常做出正确的应激反应，也不利于定位问题，这是一种不负责任的表现。

正例：用户注册的场景中，如果用户输入非法字符，或用户名称已存在，或用户输入密码过于简单，在程

序上作出分门别类的判断，并提示给用户。



【强制】捕获异常是为了处理它，不要捕获了却什么都不处理而抛弃之，如果不想处理它，请将该异常抛给它的调用者。最外层的业务使用者，必须处理异常，将其转化为用户可以理解的内容。



【强制】事务场景中，抛出异常被 catch 后，如果需要回滚，一定要注意手动回滚事务。



【强制】finally 块必须对资源对象、流对象进行关闭，有异常也要做 try-catch。

说明：如果 JDK7 及以上，可以使用 try-with-resources 方式。



【强制】不要在 finally 块中使用 return。

说明：try 块中的 return 语句执行成功后，并不马上返回，而是继续执行 finally 块中的语句，如果此处存在 return 语句，则在此直接返回，无情丢弃掉 try 块中的返回点。



【强制】捕获异常与抛异常，必须是完全匹配，或者捕获异常是抛异常的父类。

说明：如果预期对方抛的是绣球，实际接到的是铅球，就会产生意外情况。



【强制】在调用 RPC、二方包、或动态生成类的相关方法时，捕捉异常必须使用 Throwable类来进行拦截。



【推荐】方法的返回值可以为 null，不强制返回空集合，或者空对象等，必须添加注释充分说明什么情况下会返回 null 值。

说明：本手册明确防止 NPE 是调用者的责任。即使被调用方法返回空集合或者空对象，对调用者来说，也并非高枕无忧，必须考虑到远程调用失败、序列化失败、运行时异常等场景返回 null 的情况。



【推荐】防止 NPE，是程序员的基本修养，注意 NPE 产生的场景：

1） 返回类型为基本数据类型，return 包装数据类型的对象时，自动拆箱有可能产生 NPE。

 反例：public int f() { return Integer 对象}， 如果为 null，自动解箱抛 NPE。 

2） 数据库的查询结果可能为 null。 

3） 集合里的元素即使 isNotEmpty，取出的数据元素也可能为 null。 

4） 远程调用返回对象时，一律要求进行空指针判断，防止 NPE。 

5） 对于 Session 中获取的数据，建议进行 NPE 检查，避免空指针。

6） 级联调用 obj.getA().getB().getC()；一连串调用，易产生 NPE。

正例：使用 JDK8 的 Optional 类来防止 NPE 问题。



【推荐】定义时区分 unchecked / checked 异常，避免直接抛出 new RuntimeException()，更不允许抛出 Exception 或者 Throwable，应使用有业务含义的自定义异常。推荐业界已定义过的自定义异常，如：DAOException / ServiceException 等。



【参考】对于公司外的 http/api 开放接口必须使用 errorCode；而应用内部推荐异常抛出；

跨应用间 RPC 调用优先考虑使用 Result 方式，封装 isSuccess()方法、errorCode、errorMessage；而应用内部直接抛出异常即可。

说明：关于 RPC 方法返回方式使用 Result 方式的理由：

1）使用抛异常返回方式，调用方如果没有捕获到就会产生运行时错误。

2）如果不加栈信息，只是 new 自定义异常，加入自己的理解的 error message，对于调用端解决问题的帮助不会太多。如果加了栈信息，在频繁调用出错的情况下，数据序列化和传输的性能损耗也是问题。



(三) 日志规约

【强制】应用中不可直接使用日志系统（Log4j、Logback）中的 API，而应依赖使用日志框架（SLF4J、JCL--Jakarta Commons Logging）中的 API，使用门面模式的日志框架，有利于维护和各个类的日志处理方式统一。

说明：日志框架（SLF4J、JCL--Jakarta Commons Logging）的使用方式（推荐使用 SLF4J）



【强制】所有日志文件至少保存 15 天，因为有些异常具备以“周”为频次发生的特点。对于当天日志，以“应用名.log”来保存，保存在/home/admin/应用名/logs/目录下，过往日志格式为: {logname}.log.{保存日期}，日期格式：yyyy-MM-dd

正例：以 aap 应用为例，日志保存在/home/admin/aapserver/logs/aap.log，历史日志名称为aap.log.2016-08-01



【强制】根据国家法律，网络运行状态、网络安全事件、个人敏感信息操作等相关记录，留存的日志不少于六个月，并且进行网络多机备份。



【强制】在日志输出时，字符串变量之间的拼接使用占位符的方式。

说明：因为 String 字符串的拼接会使用 StringBuilder 的 append()方式，有一定的性能损耗。使用占位符仅

是替换动作，可以有效提升性能。

正例：logger.debug("Processing trade with id: {} and symbol: {}", id, symbol);



【强制】对于 trace/debug/info 级别的日志输出，必须进行日志级别的开关判断。

说明：虽然在 debug(参数)的方法体内第一行代码 isDisabled(Level.DEBUG_INT)为真时（Slf4j 的常见实现

Log4j 和 Logback），就直接 return，但是参数可能会进行字符串拼接运算。此外，如果 debug(getName())

这种参数内有 getName()方法调用，无谓浪费方法调用的开销。

```
正例：

// 如果判断为真，那么可以输出 trace 和 debug 级别的日志

if (logger.isDebugEnabled()) {

 logger.debug("Current ID is: {} and name is: {}", id, getName());

}

```



【强制】避免重复打印日志，浪费磁盘空间，务必在日志配置文件中设置 additivity=false。

正例：<logger name="com.taobao.dubbo.config" additivity="false"> 



【强制】生产环境禁止直接使用 System.out 或 System.err 输出日志或使用e.printStackTrace()打印异常堆栈。

说明：标准日志输出与标准错误输出文件每次 Jboss 重启时才滚动，如果大量输出送往这两个文件，容易造成文件大小超过操作系统大小限制。



【强制】异常信息应该包括两类信息：案发现场信息和异常堆栈信息。如果不处理，那么通过关键字 throws 往上抛出。

正例：logger.error("inputParams:{} and errorMessage:{}", 各类参数或者对象 toString(), e.getMessage(), e);



【强制】日志打印时禁止直接用 JSON 工具将对象转换成 String。

说明：如果对象里某些 get 方法被覆写，存在抛出异常的情况，则可能会因为打印日志而影响正常业务流

程的执行。

正例：打印日志时仅打印出业务相关属性值或者调用其对象的 toString()方法。



【推荐】谨慎地记录日志。生产环境禁止输出 debug 日志；有选择地输出 info 日志；如果使用warn 来记录刚上线时的业务行为信息，一定要注意日志输出量的问题，避免把服务器磁盘撑爆，并记得及时删除这些观察日志。



【推荐】可以使用 warn 日志级别来记录用户输入参数错误的情况，避免用户投诉时，无所适从。如非必要，请不要在此场景打出 error 级别，避免频繁报警。

说明：注意日志输出的级别，error 级别只记录系统逻辑出错、异常或者重要的错误信息。



# 三、单元测试



单元测试中不准使用 System.out 来进行人肉验证，必须使用 assert 来验证



【强制】保持单元测试的独立性。为了保证单元测试稳定可靠且便于维护，单元测试用例之间决不能互相调用，也不能依赖执行的先后次序。

反例：method2 需要依赖 method1 的执行，将执行结果作为 method2 的输入。



【强制】单元测试代码必须写在如下工程目录：src/test/java，不允许写在业务代码目录下。

说明：源码编译时会跳过此目录，而单元测试框架默认是扫描此目录。



【推荐】编写单元测试代码遵守 BCDE 原则，以保证被测试模块的交付质量。

⚫ B：Border，边界值测试，包括循环边界、特殊取值、特殊时间点、数据顺序等。

⚫ C：Correct，正确的输入，并得到预期的结果。

⚫ D：Design，与设计文档相结合，来编写单元测试。

⚫ E：Error，强制错误信息输入（如：非法数据、异常流程、业务允许外等），并得到预期的结果。



【推荐】对于数据库相关的查询，更新，删除等操作，不能假设数据库里的数据是存在的，或者直接操作数据库把数据插入进去，请使用程序插入或者导入数据的方式来准备数据。

反例：删除某一行数据的单元测试，在数据库中，先直接手动增加一行作为删除目标，但是这一行新增数

据并不符合业务插入规则，导致测试结果异常。



【推荐】和数据库相关的单元测试，可以设定自动回滚机制，不给数据库造成脏数据。或者对单元测试产生的数据有明确的前后缀标识。

正例：在阿里巴巴企业智能事业部的内部单元测试中，使用 *ENTERPRISE_INTELLIGENCE _UNIT_TEST*的前缀来标识单元测试相关代码。



# 四、安全规约

【强制】隶属于用户个人的页面或者功能必须进行权限控制校验。

说明：防止没有做水平权限校验就可随意访问、修改、删除别人的数据，比如查看他人的私信内容。



【强制】用户敏感数据禁止直接展示，必须对展示数据进行脱敏。

说明：中国大陆个人手机号码显示：139****1219，隐藏中间 4 位，防止隐私泄露。



【强制】用户输入的 SQL 参数严格使用参数绑定或者 METADATA 字段值限定，防止 SQL 注入，禁止字符串拼接 SQL 访问数据库。

反例：某系统签名大量被恶意修改，即是因为对于危险字符 # --没有进行转义，导致数据库更新时，where后边的信息被注释掉，对全库进行更新。



【强制】用户请求传入的任何参数必须做有效性验证。

说明：忽略参数校验可能导致：

⚫ page size 过大导致内存溢出

⚫ 恶意 order by 导致数据库慢查询

⚫ 缓存击穿

⚫ SSRF

⚫ 任意重定向

⚫ SQL 注入，Shell 注入，反序列化注入

⚫ 正则输入源串拒绝服务 ReDoS

Java 代码用正则来验证客户端的输入，有些正则写法验证普通用户输入没有问题，但是如果攻击人员使用的是特殊构造的字符串来验证，有可能导致死循环的结果。



【强制】表单、AJAX 提交必须执行 CSRF 安全验证。

说明：CSRF(Cross-site request forgery)跨站请求伪造是一类常见编程漏洞。对于存在 CSRF 漏洞的应用/网站，攻击者可以事先构造好 URL，只要受害者用户一访问，后台便在用户不知情的情况下对数据库中用户参数进行相应修改。



【强制】在使用平台资源，譬如短信、邮件、电话、下单、支付，必须实现正确的防重放的机制，如数量限制、疲劳度控制、验证码校验，避免被滥刷而导致资损。

说明：如注册时发送验证码到手机，如果没有限制次数和频率，那么可以利用此功能骚扰到其它用户，并造成短信平台资源浪费。



【推荐】发贴、评论、发送即时消息等用户生成内容的场景必须实现防刷、文本内容违禁词过滤等风控策略。



# 五、MySQL 数据库 

## (一) 建表规约

【强制】表达是与否概念的字段，必须使用 is_xxx 的方式命名，数据类型是 unsigned tinyint（1 表示是，0 表示否）。

正例：表达逻辑删除的字段名 is_deleted，1 表示删除，0 表示未删除。



【强制】表名、字段名必须使用小写字母或数字，禁止出现数字开头，禁止两个下划线中间只出现数字。数据库字段名的修改代价很大，因为无法进行预发布，所以字段名称需要慎重考虑。

说明：MySQL 在 Windows 下不区分大小写，但在 Linux 下默认是区分大小写。因此，数据库名、表名、

字段名，都不允许出现任何大写字母，避免节外生枝。

正例：aliyun_admin，rdc_config，level3_name



【强制】主键索引名为 pk_字段名；唯一索引名为 uk_字段名；普通索引名则为 idx_字段名。

说明：pk_ 即 primary key；uk_ 即 unique key；idx_ 即 index 的简称。



【强制】小数类型为 decimal，禁止使用 float 和 double。

说明：在存储的时候，float 和 double 都存在精度损失的问题，很可能在比较值的时候，得到不正确的结果。如果存储的数据范围超过 decimal 的范围，建议将数据拆成整数和小数并分开存储。



【强制】如果存储的字符串长度几乎相等，使用 char 定长字符串类型。



【强制】varchar 是可变长字符串，不预先分配存储空间，长度不要超过 5000，如果存储长度大于此值，定义字段类型为 text，独立出来一张表，用主键来对应，避免影响其它字段索引效率。



【强制】表必备三字段：id, create_time, update_time。

说明：其中 id 必为主键，类型为 bigint unsigned、单表时自增、步长为 1。create_time, update_time的类型均为 datetime 类型，前者现在时表示主动式创建，后者过去分词表示被动式更新。



【推荐】表的命名最好是遵循“业务名称_表的作用”。

正例：alipay_task / force_project / trade_config



【推荐】单表行数超过 500 万行或者单表容量超过 2GB，才推荐进行分库分表。

说明：如果预计三年后的数据量根本达不到这个级别，请不要在创建表时就分库分表。



【参考】合适的字符存储长度，不但节约数据库表空间、节约索引存储，更重要的是提升检索速度。

正例：无符号值可以避免误存负数，且扩大了表示范围。



 ##   (二) 索引规约

【强制】业务上具有唯一特性的字段，即使是组合字段，也必须建成唯一索引。

说明：不要以为唯一索引影响了 insert 速度，这个速度损耗可以忽略，但提高查找速度是明显的；另外，即使在应用层做了非常完善的校验控制，只要没有唯一索引，根据墨菲定律，必然有脏数据产生。



【强制】超过三个表禁止 join。需要 join 的字段，数据类型保持绝对一致；多表关联查询时，保证被关联的字段需要有索引。

说明：即使双表 join 也要注意表索引、SQL 性能。



【强制】在 varchar 字段上建立索引时，必须指定索引长度，没必要对全字段建立索引，根据

实际文本区分度决定索引长度。



【强制】页面搜索严禁左模糊或者全模糊，如果需要请走搜索引擎来解决。

说明：索引文件具有 B-Tree 的最左前缀匹配特性，如果左边的值未确定，那么无法使用此索引。



【推荐】如果有 order by 的场景，请注意利用索引的有序性。order by 最后的字段是组合索引的一部分，并且放在索引组合顺序的最后，避免出现 file_sort 的情况，影响查询性能。

正例：where a=? and b=? order by c; 索引：a_b_c

反例：索引如果存在范围查询，那么索引有序性无法利用，如：WHERE a>10 ORDER BY b; 索引 a_b 无法排序。



【推荐】利用覆盖索引来进行查询操作，避免回表。

说明：如果一本书需要知道第 11 章是什么标题，会翻开第 11 章对应的那一页吗？目录浏览一下就好，这个目录就是起到覆盖索引的作用。

正例：能够建立索引的种类分为主键索引、唯一索引、普通索引三种，而覆盖索引只是一种查询的一种效果，用 explain 的结果，extra 列会出现：using index。



【推荐】利用延迟关联或者子查询优化超多分页场景。

说明：MySQL 并不是跳过 offset 行，而是取 offset+N 行，然后返回放弃前 offset 行，返回 N 行，那当offset 特别大的时候，效率就非常的低下，要么控制返回的总页数，要么对超过特定阈值的页数进行 SQL改写。

正例：先快速定位需要获取的 id 段，然后再关联：

```
 SELECT t1.* FROM 表 1 as t1, (select id from 表 1 where 条件 LIMIT 100000,20 ) as t2 where t1.id=t2.id
```



【推荐】SQL 性能优化的目标：至少要达到 range 级别，要求是 ref 级别，如果可以是 consts最好。

说明：

1） consts 单表中最多只有一个匹配行（主键或者唯一索引），在优化阶段即可读取到数据。

2） ref 指的是使用普通的索引（normal index）。 

3） range 对索引进行范围检索。

反例：explain 表的结果，type=index，索引物理文件全扫描，速度非常慢，这个 index 级别比较 range还低，与全表扫描是小巫见大巫。



【推荐】建组合索引的时候，区分度最高的在最左边。

正例：如果 where a=? and b=?，a 列的几乎接近于唯一值，那么只需要单建 idx_a 索引即可。

说明：存在非等号和等号混合判断条件时，在建索引时，请把等号条件的列前置。如：where c>? and d=? 那么即使 c 的区分度更高，也必须把 d 放在索引的最前列，即建立组合索引 idx_d_c。



【参考】创建索引时避免有如下极端误解：

1） 索引宁滥勿缺。认为一个查询就需要建一个索引。

2） 吝啬索引的创建。认为索引会消耗空间、严重拖慢记录的更新以及行的新增速度。

3） 抵制惟一索引。认为惟一索引一律需要在应用层通过“先查后插”方式解决。



## (三) SQL 语句

【强制】不要使用 count(列名)或 count(常量)来替代 count(*)，count(*)是 SQL92 定义的标准统计行数的语法，跟数据库无关，跟 NULL 和非 NULL 无关。

> 说明：count(*)会统计值为 NULL 的行，而 count(列名)不会统计此列为 NULL 值的行。



【强制】count(distinct col) 计算该列除NULL之外的不重复行数，注意 count(distinct col1, col2) 如果其中一列全为NULL，那么即使另一列有不同的值，也返回为0。



【强制】使用ISNULL()来判断是否为NULL值。

 说明：NULL与任何值的直接比较都为NULL。

1） NULL<>NULL的返回结果是NULL，而不是false。

2） NULL=NULL的返回结果是NULL，而不是true。 

3） NULL<>1的返回结果是NULL，而不是true。



【强制】代码中写分页查询逻辑时，若count为0应直接返回，避免执行后面的分页语句。



【强制】不得使用外键与级联，一切外键概念必须在应用层解决。

> 说明：以学生和成绩的关系为例，学生表中的student_id是主键，那么成绩表中的student_id则为外键。如果更新学生表中的student_id，同时触发成绩表中的student_id更新，即为级联更新。外键与级联更新适用于单机低并发，不适合分布式、高并发集群；级联更新是强阻塞，存在数据库更新风暴的风险；外键影响数据库的插入速度。



【强制】禁止使用存储过程，存储过程难以调试和扩展，更没有移植性。



【强制】数据订正（特别是删除、修改记录操作）时，要先select，避免出现误删除，确认无误才能执行更新语句。



【推荐】in操作能避免则避免，若实在避免不了，需要仔细评估in后边的集合元素数量，控制在1000个之内。



13【参考】TRUNCATE TABLE 比 DELETE 速度快，且使用的系统和事务日志资源少，但TRUNCATE无事务且不触发trigger，有可能造成事故，故不建议在开发代码中使用此语句。 说明：TRUNCATE TABLE 在功能上与不带 WHERE 子句的 DELETE 语句相同。



## (四) ORM映射

【强制】在表查询中，一律不要使用 * 作为查询的字段列表，需要哪些字段必须明确写明。 

> 说明：
>
> 1）增加查询分析器解析成本。
>
> 2）增减字段容易与resultMap配置不一致。
>
> 3）无用字段增加网络消耗，尤其是text类型的字段。



4【强制】sql.xml配置参数使用：#{}，#param# 不要使用${} 此种方式容易出现SQL注入。



6【强制】不允许直接拿HashMap与Hashtable作为查询结果集的输出。



7【强制】更新数据表记录时，必须同时更新记录对应的update_time字段值为当前时间。



8【推荐】不要写一个大而全的数据更新接口。传入为POJO类，不管是不是自己的目标更新字段，都进行update table set c1=value1,c2=value2,c3=value3; 这是不对的。执行SQL时，不要更新无改动的字段，一是易出错；二是效率低；三是增加binlog存储。



9【参考】@Transactional事务不要滥用。事务会影响数据库的QPS，另外使用事务的地方需要考虑各方面的回滚方案，包括缓存回滚、搜索引擎回滚、消息补偿、统计修正等。





# 六、工程结构

## (一) 应用分层

- 开放API层：可直接封装Service接口暴露成RPC接口；通过Web封装成http接口；网关控制层等。
- 终端显示层：各个端的模板渲染并执行显示的层。当前主要是velocity渲染，JS渲染，JSP渲染，移动端展示等。



Manager层：通用业务处理层，它有如下特征： 

1） 对第三方平台封装的层，预处理返回结果及转化异常信息，适配上层接口。 

2） 对Service层通用能力的下沉，如缓存方案、中间件通用处理。 

3） 与DAO层交互，对多个DAO的组合复用



在DAO层，产生的异常类型有很多，无法用细粒度的异常进行catch，使用catch(Exception e)方式，并throw new DAOException(e)，不需要打印日志，因为日志在Manager/Service层一定需要捕获并打印到日志文件中去，如果同台服务器再打日志，浪费性能和存储。

在Service层出现异常时，必须记录出错日志到磁盘，尽可能带上参数信息，相当于保护案发现场。Manager层与Service同机部署，日志方式与DAO层处理一致，如果是单独部署，则采用与Service一致的处理方式

Web层绝不应该继续往上抛异常，因为已经处于顶层，如果意识到这个异常将导致页面无法正常渲染，那么就应该直接跳转到友好错误页面，尽量加上友好的错误提示信息。开放接口层要将异常处理成错误码和错误信息方式返回。



【参考】分层领域模型规约：  

- DO（Data Object）：此对象与数据库表结构一一对应，通过DAO层向上传输数据源对象。 

-  DTO（Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象。 

-  BO（Business Object）：业务对象，可以由Service层输出的封装业务逻辑的对象。

-  Query：数据查询对象，各层接收上层的查询请求。注意超过2个参数的查询封装，禁止使用Map类来传输。 

-  VO（View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。



## (二) 二方库依赖

【强制】二方库里可以定义枚举类型，参数可以使用枚举类型，但是接口返回值不允许使用枚举类型或者包含枚举类型的POJO对象。



【强制】禁止在子项目的pom依赖中出现相同的GroupId，相同的ArtifactId，但是不同的Version。



## (三) 服务器

【推荐】高并发服务器建议调小TCP协议的time_wait超时时间。 说明：操作系统默认240秒后，才会关闭处于time_wait状态的连接，在高并发访问下，服务器端会因为处于time_wait的连接数太多，可能无法建立新的连接，所以需要在服务器上调小此等待值。

【推荐】给JVM环境参数设置-XX:+HeapDumpOnOutOfMemoryError参数，让JVM碰到OOM场景时输出dump信息。



【推荐】在线上生产环境，JVM的Xms和Xmx设置一样大小的内存容量，避免在GC 后调整堆大小带来的压力。



# 七、设计规约

【推荐】谨慎使用继承的方式来进行扩展，优先使用聚合/组合的方式来实现。 

> 说明：不得已使用继承的话，必须符合里氏代换原则，此原则说父类能够出现的地方子类一定能够出现，比如，“把钱交出来”，钱的子类美元、欧元、人民币等都可以出现。



【推荐】系统设计阶段，共性业务或公共行为抽取出来公共模块、公共配置、公共类、公共方法等，在系统中不出现重复代码的情况，即DRY原则（Don't Repeat Yourself）。 

> 说明：随着代码的重复次数不断增加，维护成本指数级上升。随意复制和粘贴代码，必然会导致代码的重复，在维护代码时，需要修改所有的副本，容易遗漏。必要时抽取共性方法，或者抽象公共类，甚至是组件化。 
>
> 正例：一个类中有多个public方法，都需要进行数行相同的参数校验操作，这个时候请抽取：
> private boolean checkParam(DTO dto) {...}




