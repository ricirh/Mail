package com.petty.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.petty.merchant.dao")
public class MerChantApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(MerChantApplicaiton.class);
    }
}
