package com.tubanurbalci.demoschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableJpaRepositories("com.tubanurbalci.demoschool.repository")
@EntityScan("com.tubanurbalci.demoschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class DemoSchoolApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSchoolApplication.class, args);
  }

}
