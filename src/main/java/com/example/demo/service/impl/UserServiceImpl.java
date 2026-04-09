package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUserInfoById(Long id) {
        // 这里可以加入更复杂的业务逻辑，比如判断用户是否被封禁，或者关联查询其他信息
        // 目前仅做简单的透传查询
        return this.getById(id);
    }
}