package org.mvnsearch.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Microapp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Microapp1Application.class, args);
    }
}
