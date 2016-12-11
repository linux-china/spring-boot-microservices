Spring Boot Admin Server
==================================
Admin UI for administration of spring boot applications

### how to use

1. please add following dependency in your application's pom.xml:


    <dependency>
       <groupId>de.codecentric</groupId>
       <artifactId>spring-boot-admin-starter-client</artifactId>
       <version>1.4.4</version>
    </dependency>

2. If you want to enable JMX-HTTP support, such log view, please add Jolokia dependency:


    <dependency>
           <groupId>org.jolokia</groupId>
           <artifactId>jolokia-core</artifactId>
    </dependency>

then add jmx support in your logback.xml:

    <configuration>
        <jmxConfigurator/>
        .....
    </configuration>

1. add following pair in your application.properties


     spring.boot.admin.url=http://localhost:8888
2. open browser to visit boot admin server

### references

*  https://github.com/codecentric/spring-boot-admin