package org.example.basic;

import lombok.Data;

@Data
public class Credentials {
    private String authMethod;
    private String username;
    private String password;

    // standard getters and setters
}