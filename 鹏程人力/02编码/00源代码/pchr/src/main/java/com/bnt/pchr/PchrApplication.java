package com.bnt.pchr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   // 开启定时功能
public class PchrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PchrApplication.class, args);
    }

}
