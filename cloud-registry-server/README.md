Cloud Registry Server
==================================
Eureka Registry Server, the default port is 8761, please visit http://localhost:8761

### How to use

* Add spring-cloud-starter-eureka dependency in your pom.xml
```xml
   <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
   </dependency>
```
* Add Eureka configuration in your application.yml
```yaml
         eureka:
           instance:
             prefer-ip-address: true
           client:
             fetchRegistry: false
             serviceUrl:
               defaultZone: http://localhost:8761/eureka/
```
or application.properties
```properties
         eureka.instance.prefer-ip-address=true
         eureka.client.fetch-registry=false
         eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
```
Please notice: you can add multi url in defaultZone to setup cluster, such as "http://dsc01:8761/eureka/,http://dsc02:8762/eureka/" for both client and server. 

* Add @EnableDiscoveryClient for your Spring Boot Application

### metadata meta
You can add metadata for Eureka instance, such as following:
```properties
  eureka.instance.metadata-map.management.port=${management.port:-${server.port}}
```