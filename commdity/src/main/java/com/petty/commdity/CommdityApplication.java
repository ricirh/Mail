package com.petty.commdity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.petty.commdity.dao")
public class CommdityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommdityApplication.class);
    }
}
