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
           <version>1.1.0.RELEASE</version>
    </dependency>

2. Bootstrap Environment from server. In your bootstrap.properties add following code:


    spring.cloud.config.uri: http://myconfigserver.com:8080/

3. verify your properties:


    $ curl http://localhost:8080/app_name/master
    $ curl http://localhost:8080/app_name/production/master

4. add @RefreshScope for your bean
5. POST to /refresh to refresh the configuration

### Testing

     $ http http://localhost:9380/demo/default/master

### how to write properties file

1. application.properties: global properties for all apps
2. appname.properties: app properties
3. appname-profile.properties: app profile properties


