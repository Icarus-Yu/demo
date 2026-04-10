package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.entity.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.vo.UserVO;

import java.util.List;

public interface UserService extends IService<User> {
    // 除了 MyBatis-Plus 默认的 getById 等方法外，可以在这里定义复杂的业务接口
    UserVO getUserInfoById(Long id);

    UserVO createUser(UserDTO userDTO);

    UserVO updateUser(Long id, UserDTO userDTO);

    boolean deleteUser(Long id);

    List<UserVO> listAllUsers();
}