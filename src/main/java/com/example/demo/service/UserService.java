package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;

public interface UserService extends IService<User> {
    // 除了 MyBatis-Plus 默认的 getById 等方法外，可以在这里定义复杂的业务接口
    User getUserInfoById(Long id);
}