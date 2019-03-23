package com.antmog.vk.bot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "vk")
@Data
public class ProjectSettings {
    private String serverName;
    private String serverPort;
    private String protectedKey;
    private String serviceKey;
    private String getCodeUrl;
    private String authTokenEndpoint;
    private Integer applicationId;
    private Integer scope;

    private Integer salovaGroupId;
    private Integer myGroupId;
}