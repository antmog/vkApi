package com.antmog.vk.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController("/")
public class Controller {

    @Autowired
    private VkService vkService;

//    @GetMapping("/auth")
//    public String auth() {
//        vkService.auth();
//        return "auth";
//    }

    @GetMapping("/auth")
    public RedirectView redirectWithUsingRedirectView(
            RedirectAttributes attributes) {
//        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
//        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView(vkService.getGetCodeUrl());
    }

    @GetMapping("/setcode")
    public String setCode(@RequestParam String code) {
        // received code
        //vkService.smth();
        return "auth";
    }
}