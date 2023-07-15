package com.jan1ooo.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.jan1ooo.core.model"})
@EnableJpaRepositories({"com.jan1ooo.core.repository"})
public class MicroserviceAcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAcademyApplication.class, args);
    }

}
