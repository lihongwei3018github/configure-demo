package org.example.basic;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Map;
@Configuration
@ConfigurationProperties(prefix = "mail")
@Data
public class ConfigProperties {
    
    private String hostName;
    @Min(1025)
    @Max(65536)
    private int port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;

}