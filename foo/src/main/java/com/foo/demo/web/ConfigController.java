package com.foo.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("config")
@RestController
@RefreshScope
public class ConfigController {

    @Value("${profile}")
    private String profile;

    @Value("${super.profile}")
    private String sProfile;


    @RequestMapping("profile")
    public String getProfile() {

        return profile;
    }
    @RequestMapping("sProfile")
    public String getProfile1() {

        return sProfile;
    }
}
