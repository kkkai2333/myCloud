package com.customer.demo.web;


import com.alibaba.fastjson.JSONObject;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("getUser/{id}")
    public String getAdmin(@PathVariable Long id) {
        User user = restTemplate.getForObject("http://microservice-privoder/user/getUser/{id}", User.class, id);
        return JSONObject.toJSONString(user);
    }
}
