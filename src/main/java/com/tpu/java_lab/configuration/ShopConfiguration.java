package com.tpu.java_lab.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tpu.java_lab")
public class ShopConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ShopConfiguration.class, args);
    }

}
