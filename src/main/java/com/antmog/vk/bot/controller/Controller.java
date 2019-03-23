package com.antmog.vk.bot.controller;

import com.antmog.vk.bot.service.VkApiInitialisationService;
import com.antmog.vk.bot.service.VkService;
import com.antmog.vk.bot.thirdparty.VkApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RestController("/")
public class Controller {

    @Autowired
    private VkApi vkApi;
    @Autowired
    private VkApiInitialisationService vkApiInitialisationService;
    @Autowired
    private VkService vkService;

    @GetMapping("/auth")
    public RedirectView redirectWithUsingRedirectView() {
        log.debug("auth exec");
        return new RedirectView(vkApiInitialisationService.getGetCodeUrl());
    }

    @GetMapping("/auth-token")
    public ResponseEntity<HttpStatus> setCode(@RequestParam String code) {
        log.debug("auth-token exec");
        vkApi.setActor(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO: 23.03.2019 REMOVE
    @Deprecated
    @GetMapping("/test-endpoint")
    public ResponseEntity<HttpStatus> testEndpoint() {
        log.debug("test-endpoint exec");
        vkService.doSomething();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}