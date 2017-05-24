package com.shashank.tracker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.shashank.tracker.dao")
@ComponentScan("com.shashank.tracker.*")
@EntityScan("com.shashank.tracker.entity")
public class TrackerWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrackerWebApplication.class, args);
  }
}