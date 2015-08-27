Spring Boot Admin Server
==================================
Admin UI for administration of spring boot applications

### how to use

1. please add following dependency in your application's pom.xml:


    <dependency>
       <groupId>de.codecentric</groupId>
       <artifactId>spring-boot-admin-starter-client</artifactId>
       <version>1.2.3</version>
    </dependency>
2. add following pair in your application.properties


     spring.boot.admin.url=http://boot_admin_server:8080
3. open browser to visit boot admin server

### references

*  https://github.com/codecentric/spring-boot-admin