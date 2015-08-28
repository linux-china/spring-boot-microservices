Cloud Config Server
=====================================
Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system.


### Settings

Please change git url in application.properties

### how to use

1. please add dependency in your pom.xml.


    <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-config</artifactId>
           <version>1.0.2.RELEASE</version>
    </dependency>

2. in your bootstrap.properties add following code:


    spring.cloud.config.uri: http://myconfigserver.com:8080/

3. verify your properties:


    $ curl http://localhost:8080/app_name.properties

### how to write properties file

1. application.properties: global properties for all apps
2. app_name.properties: app properties
3. app_name-profile.properties: app profile properties

