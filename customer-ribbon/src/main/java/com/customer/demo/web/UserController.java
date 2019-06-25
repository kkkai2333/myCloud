package com.customer.demo.web;


import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("customerUser")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("getAdmin")
    public String getAdmin() {
        return restTemplate.getForObject("http://microservice-privoder/user/getAdmin", String.class);
    }

    @HystrixCommand
    @GetMapping("getUser/{id}")
    public String getUser(@PathVariable Long id) {
        User user = restTemplate.getForObject("http://microservice-privoder/user/getUser/{id}", User.class, id);
        return JSONObject.toJSONString(user);
    }

    public String fail() {
        return "fail";
    }
}
