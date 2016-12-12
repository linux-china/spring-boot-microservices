Spring Boot Admin Server
==================================
Admin UI for administration of spring boot applications.

### Howo to start server
Spring Boot Admin Server integrats with Eureka to fetch applications.

* Start Eureka Server first
* Start Spring Boot Admin Server.

### How to use in applications

* please add following dependency in your application's pom.xml:
```xml
    <dependency>
       <groupId>de.codecentric</groupId>
       <artifactId>spring-boot-admin-starter-client</artifactId>
       <version>1.4.4</version>
    </dependency>
```
* If you want to enable JMX-HTTP support, such log view, please add Jolokia dependency:
```xml
    <dependency>
           <groupId>org.jolokia</groupId>
           <artifactId>jolokia-core</artifactId>
    </dependency>
```
* Add JMX support in your logback-spring.xml:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <springProperty scope="context" name="logging.file" source="logging.file"/>
    <springProperty scope="context" name="logging.path" source="logging.path"/>
    <springProperty scope="context" name="spring.application.name" source="spring.application.name"/>
    <property name="LOG_FILE" value="${logging.path:-.}/${logging.file:-${spring.application.name:-spring}.log}"/>

    <include resource="org/springframework/boot/logging/logback/base.xml"/>
    <jmxConfigurator/>

    <root level="ERROR">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </root>

</configuration>
```
* Add following pair in your application.properties
```properties
     spring.boot.admin.url=http://localhost:9761
```
* Open browser to visit boot admin server: http://localhost:9761

### references

* Spring Boot Admin Docs: http://codecentric.github.io/spring-boot-admin/1.4.4/
*  Spring Boot Admin Git: https://github.com/codecentric/spring-boot-admin