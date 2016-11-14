package org.mvnsearch.boot.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootConsulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsulServerApplication.class, args);
    }
}
