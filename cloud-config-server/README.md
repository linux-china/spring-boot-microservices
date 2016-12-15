Cloud Config Server
=====================================
Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system.

### Settings

Please change git url in application.properties, and you can check by http://localhost:8888/configserver/default

### How to use

* please add dependency in your pom.xml.
```xml

    <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
```
* Bootstrap Environment from server. In your bootstrap.properties add following code:
```
     spring.cloud.config.uri: http://localhost:8888/
```
* Verify your properties:
```
    $ curl http://localhost:8888/demo/master
    $ curl http://localhost:8888/demo/prod/master
```
* add @RefreshScope for your bean
* Change properties and push them to git repository
* Invoke 'curl -X POST http://localhost:8080/refresh' to refresh config

### Testing
Config Server with Git adopts following rules to get configuration:

* properties or yml: "/{name}/{profile}/{label}": name is application name, profile is Spring profile name, and label is git branch or tag name.


     $ http http://localhost:8888/demo/default/master


* plain text:  "/{name}/{profile}/{label}/{path}"

     $ curl http://localhost:8888/demo/default/master/demo.conf
     $ curl http://localhost:8888/demo/default/master/hibernate/demo.xml

### how to write properties file

1. application.properties: global properties for all apps
2. appname.properties: app properties
3. appname-profile.properties: app profile properties

### How to integrate with Eureka

* Add spring-cloud-starter-eureka dependency in your pom.xml:
```xml
 <dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-eureka</artifactId>
 </dependency>
```
* Add @EnableDiscoveryClient in your applictaion
* add property in the applicaton.properties
```properties
eureka.instance.prefer-ip-address=true
eureka.client.fetch-registry=false
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
```

### Spring Cloud CLI Launcher

please copy configserver.yml to $HOME/.spring-cloud/configserver.yml and execute:

     $ spring cloud configserver

### 支持的git url

* file: file:///${user.home}/config-repo
* git https url: https://github.com/myorg/{application}
* git url: git@gitlab.yourdomain.com:myorg/config-repo

### References

* Spring Config Server: http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html

