package com.example.demo.controller;



import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    //创建一个服务采取控制反转的方法
    private UserService userService;

    @GetMapping("/user")
    //
    public User getUserInfo(@RequestParam(value="id", defaultValue = "1") Long id) {
        // Controller 层不再关心数据是如何查出来的，只调用 Service 提供的方法
        //这里得到的是
        return userService.getUserInfoById(id);
    }
}