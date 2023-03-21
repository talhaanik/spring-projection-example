package com.example.demoprojection;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demoprojection",
  repositoryBaseClass = ExtendedRepositoryImpl.class)
public class CustomJPAH2Config {
    // additional JPA Configuration
}