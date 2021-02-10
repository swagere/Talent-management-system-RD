package com.kve.talent_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.kve.**.mapper"})
public class TalentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentManagementSystemApplication.class, args);
    }

}
