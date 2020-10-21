package org.sean.okr.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.sean.okr","com.alibaba.cola"})
public class OkrStartApplication {
    public static void main(String[] args) {

        SpringApplication.run(OkrStartApplication.class, args);

    }
}
