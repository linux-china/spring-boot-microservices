package org.mvnsearch.app1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Microapp3Application {
    private static final Logger log = LoggerFactory.getLogger(Microapp3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Microapp3Application.class, args);
    }

    /**
     * Use this for debugging (or if there is no Zipkin server running on port 9411)
     *
     * @return  zipkin span reporter
     */
    @Bean
    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
    public ZipkinSpanReporter spanCollector() {
        return span -> log.info(String.format("Reporting span [%s]", span));
    }
}
