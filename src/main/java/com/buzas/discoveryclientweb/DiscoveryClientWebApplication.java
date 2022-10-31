package com.buzas.discoveryclientweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiscoveryClientWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryClientWebApplication.class, args);
    }

}
