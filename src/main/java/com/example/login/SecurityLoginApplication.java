package com.example.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.login.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityLoginApplication.class, args);
    }

}
