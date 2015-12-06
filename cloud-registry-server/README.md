Cloud Registry Server
==================================

Eureka Server


### how to use

1. please add following dependency in your pom.xml


         <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-eureka</artifactId>
                <version>1.0.3.RELEASE</version>
         </dependency>
2. add following code in your application.yml


         eureka:
           client:
             serviceUrl:
               defaultZone: http://localhost:8761/eureka/
    
or application.properties

          eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/

Please notice: you can add multi url in defaultZone to setup cluster, such as "http://dsc01:8761/eureka/,http://dsc02:8762/eureka/" for both client and server. 
3. add @EnableDiscoveryClient for your Spring Boot Application