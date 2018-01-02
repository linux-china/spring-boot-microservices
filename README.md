Spring Boot MicroServices
==================================

### environment

please install Java 8 JCE: http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

### Services

* Config Server
* Eureka Registry Server
* Spring Boot Admin Server
* Spring Cloud DataFlow Server
* Trampoline: https://github.com/ErnestOrt/Trampoline 

### How to start services

* Start Eureka
* Start Config Server（integrated with eureka)
* Start Spring Boot Admin (integrated with eureka)

### Maven plugins

* maven-compiler-plugin: 1.8 compile
* spring-boot-maven-plugin: build-info
* git-commit-id-plugin: git full mode

###Spring Cloud Consul

#### Startup

* docker-compose up -d
* visit http://localhost:8500/ui/ for Consul
* visit http://localhost:9411/zipkin/ for Zipkin

#### Consul Configuration

Consul Key/Value支持的Spring config Server目录结构如下：

    config/testApp,dev/
    config/testApp/
    config/application,dev/
    config/application/

接下来就是在这些目录下创建对应的Key/Value。

* MicroServices with Consul: https://www.infoq.com/articles/Microservices-SpringBoot

### Tips

* 不同Spring Boot加载的配置问题，可以通过 --spring.profiles.active=15X 来激活全局的 application-15X.properties这样

### Reference

* Spring Cloud: http://cloud.spring.io/spring-cloud-static/Camden.SR3/
* Spring Cloud Netflix: http://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/1.2.3.RELEASE/
* Spring Cloud Consul: http://cloud.spring.io/spring-cloud-consul/
* Spring Cloud ZooKeeper: http://cloud.spring.io/spring-cloud-zookeeper/spring-cloud-zookeeper.html
* Spring Cloud CLI Launcher: https://spring.io/blog/2016/11/02/introducing-the-spring-cloud-cli-launcher
