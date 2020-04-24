# 基于spring MVC+MySQL的作业管理系统
# 配置aop
- pom.xml
````xml
<properties>
    <aspectj.version>1.9.1</aspectj.version>
</properties>
<!--使用AspectJ方式注解需要相应的包-->
<dependencies>

<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>${aspectj.version}</version>
</dependency>
    <dependency>
      <groupId>org.apache.geronimo.bundles</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.6.8_2</version>
    </dependency>
</dependencies>
````
- springmvcContext.xml
````xml
 <aop:aspectj-autoproxy/>   
````
# 通过SpringContextUtil获取Spring容器中的任何bean
- pom.xml
````xml
 <dependency>
      <groupId> org.aspectj</groupId >
      <artifactId> aspectjweaver</artifactId>
      <version>${aspectj.version}</version >
    </dependency>
````
# Spring 声明式事务管理
  声明式事务管理方法允许你在配置的帮助下而不是源代码硬编程来管理事务。这意味着你可以将事务管理从事务代码中隔离出来。你可以只使用注释或基于配置的 XML 来管理事务。 bean 配置会指定事务型方法。下面是与声明式事务相关的步骤：
  
  1.我们使用标签，它创建一个事务处理的建议，同时，我们定义一个匹配所有方法的切入点，我们希望这些方法是事务型的并且会引用事务型的建议。
  
  2.如果在事务型配置中包含了一个方法的名称，那么创建的建议在调用方法之前就会在事务中开始进行。
  
  3.目标方法会在 try / catch 块中执行。
  
  4.如果方法正常结束，AOP 建议会成功的提交事务，否则它执行回滚操作。
# mysql 的传播行为
# Spring Data
底层数据库
# 参考资料
https://blog.csdn.net/AinUser/article/details/82289705

https://www.w3cschool.cn/wkspring/jcny1mmg.html