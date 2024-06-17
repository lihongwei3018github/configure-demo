package org.example.springboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "database")
@Configuration
@Data
public class Database {

    String url;
    String username;
    String password;
}