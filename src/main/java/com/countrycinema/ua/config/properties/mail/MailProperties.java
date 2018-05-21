package com.countrycinema.ua.config.properties.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

    private String headerParam;
    private String encodingOptions;

    private String accountFrom;
}
