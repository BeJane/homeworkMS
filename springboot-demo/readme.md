# SpringBoot 介绍
1）它是Spring的升级版，Spring容器能做到的事情，它都能做到，而且更简便，从配置形式上来说，SpringBoot完全抛弃了繁琐的XML文件配置方式，而是替代性地用注解方式来实现，虽然本质来说，是差不多的（类似包扫描，注解扫描，类加载之类）。

（2）SpringBoot集成的插件更多，从而使用很多服务，都只是引入一个依赖，几个注解和Java类就可以用了，具体的参考相关手册。

（3）在Web应用开发这一块，之前的应用一般来说是打包成war包，再发布到相关服务器容器下（例如Tomcat），虽然SpringBoot也可以这么做，但在SpringBoot下更常见的形式是将SpringBoot应用打包成可执行jar包文件。之所以这么做，源于你可以直接将SpringBoot应用看成是一个Java Application，其Web应用可以没有webapp目录（更不用说web.xml了），它推荐使用html页面，并将其作为静态资源使用。

# 搭建demo
## 在pom文件中引入SpringBoot相关依赖
```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.1.RELEASE</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```
## 新建一个controller 包，用于存放所有的controller
- SpringBoot应用一般是打包成可执行jar包来发布的，controller中的main函数就是整个项目的入口。而之所以能这么做，是因为SpringBoot连Tomcat8作为一个插件都集成进去了，所以就不必跟之前的SSM架构下一样，还需要去在Tomcat下配置war包才能运行。
- 直接点击运行该main函数，在浏览器链接栏，输入地址http://localhost:8080/，就可以看到打印的字符串”Hello World!”了。
## 参考
- https://blog.csdn.net/u013248535/article/details/55100979