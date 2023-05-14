package com.focustechnology.sellmycar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SellMyCarApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SellMyCarApplication.class, args);
    }
}
