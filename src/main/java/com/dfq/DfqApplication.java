package com.dfq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.dfq.putao.dao")
@EnableTransactionManagement
@EnableScheduling
@Configuration
public class DfqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfqApplication.class, args);
    }

}
