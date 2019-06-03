package com.provider.demo.web;


import com.alibaba.fastjson.JSONObject;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {


    @GetMapping("getAdmin")
    public String getAdmin() {
        System.out.println("调用getAdmin方法");
        User user = new User();
        user.setId(1L);
        user.setUsername("admin");
        return JSONObject.toJSONString(user);
    }

    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("用户" + id);
        return user;
    }
}
