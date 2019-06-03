package com.customer.demo.feign;


import com.customer.demo.config.ProviderFeignConfig;
import model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "microservice-privoder/user", configuration = ProviderFeignConfig.class)
public interface ProviderFeignClient {

    @GetMapping("getAdmin")
    String getAdmin();

    @GetMapping("getUser/{id}")
    User getUser(@PathVariable("id") Long id);


}
