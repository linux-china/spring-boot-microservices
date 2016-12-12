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
           <version>1.2.2.RELEASE</version>
    </dependency>

2. Bootstrap Environment from server. In your bootstrap.properties add following code:


    spring.cloud.config.uri: http://localhost:9380/

3. verify your properties:


    $ curl http://localhost:9380/demo/master
    $ curl http://localhost:9380/demo/prod/master

4. add @RefreshScope for your bean

### Testing

     $ http http://localhost:9380/demo/default/master

### how to write properties file

1. application.properties: global properties for all apps
2. appname.properties: app properties
3. appname-profile.properties: app profile properties

### Spring Cloud CLI Launcher

please copy configserver.yml to $HOME/.spring-cloud/configserver.yml and execute:

     $ spring cloud configserver

### References

* https://spring.io/blog/2016/11/02/introducing-the-spring-cloud-cli-launcher


