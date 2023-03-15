package com.kt.sw.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.kt")
@SpringBootApplication
public class SwEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwEduApplication.class, args);
    }

}
