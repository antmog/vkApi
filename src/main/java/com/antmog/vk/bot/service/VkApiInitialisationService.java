package com.antmog.vk.bot.service;

import com.antmog.vk.bot.config.ProjectSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.antmog.vk.bot.utils.TechnicalSymbols.HOST_PORT_DELIMITER;

@Service
public class VkApiInitialisationService {

    @Autowired
    private ProjectSettings conf;

    public String getGetCodeUrl() {
        return String.format(conf.getGetCodeUrl(), conf.getApplicationId(), getRedirectUrl());
    }

    public String getRedirectUrl() {
        return conf.getServerName() + HOST_PORT_DELIMITER + conf.getServerPort() + conf.getAuthTokenEndpoint();
    }
}
