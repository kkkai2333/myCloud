package com.customer.demo.web;


import com.alibaba.fastjson.JSONObject;
import com.customer.demo.feign.ProviderFeignClient;
import com.netflix.discovery.converters.Auto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.security.Provider;

@RestController
@RequestMapping("customerUser")
public class UserController {

    @Resource
    private ProviderFeignClient providerFeignClient;

    @GetMapping("getAdmin")
    public String getAdmin() {
        return providerFeignClient.getAdmin();
    }

    @GetMapping("getUser/{id}")
    public String getAdmin(@PathVariable Long id) {
        User user = providerFeignClient.getUser(id);
        return JSONObject.toJSONString(user);
    }
}
