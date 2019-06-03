package com.provider.demo.web;


import com.alibaba.fastjson.JSONObject;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("user")
public class UserController {

    private static AtomicInteger integer = new AtomicInteger();
    private static AtomicInteger integer2 = new AtomicInteger();

    @GetMapping("getAdmin")
    public String getAdmin() {
        System.out.println("调用getAdmin方法：" + integer.incrementAndGet());
        User user = new User();
        user.setId(1L);
        user.setUsername("admin");
        return JSONObject.toJSONString(user);
    }

    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable Long id) {
        System.out.println("调用getUser方法：" + integer2.incrementAndGet());
        User user = new User();
        user.setId(id);
        user.setUsername("用户" + id);
        return user;
    }
}
