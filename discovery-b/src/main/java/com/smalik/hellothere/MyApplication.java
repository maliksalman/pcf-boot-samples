package com.smalik.hellothere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyApplication.class, args);
    }
}
