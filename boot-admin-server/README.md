Spring Boot Admin Server
==================================
Admin UI for administration of spring boot applications.

### how to start server
Spring Boot Admin Server integrates with Eureka to fetch applications.

* Start Eureka Server first
* Start Spring Boot Admin Server.

### How to use in applications
Spring Boot Admin has been integrated with Eureka Registry Server, and Boot Admin will fetch all applications from registry server.

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
* Open browser to visit boot admin server and check: http://localhost:9761

### references

* Spring Boot Admin Security: https://dzone.com/articles/a-look-at-spring-boot-admin
* Spring Boot Admin Docs: http://codecentric.github.io/spring-boot-admin/1.4.4/
* Spring Boot Admin Git: https://github.com/codecentric/spring-boot-admin
