package org.mvnsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class Sidecar1Application {

    public static void main(String[] args) {
        SpringApplication.run(Sidecar1Application.class, args);
    }
}
