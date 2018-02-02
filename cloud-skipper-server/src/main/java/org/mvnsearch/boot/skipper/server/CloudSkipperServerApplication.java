package org.mvnsearch.boot.skipper.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.cloud.deployer.spi.local.LocalDeployerAutoConfiguration;
import org.springframework.cloud.skipper.server.EnableSkipperServer;

// LocalDeployerAutoConfiguration.class,
@SpringBootApplication(exclude = {
        ManagementWebSecurityAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        SessionAutoConfiguration.class
})
@EnableSkipperServer
public class CloudSkipperServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSkipperServerApplication.class, args);
    }
}
