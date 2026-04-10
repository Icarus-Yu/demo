package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.vo.UserVO;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理", description = "用户相关接口")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    //创建一个服务采取控制反转的方法
    private final UserService userService;

    @Operation(summary = "通过ID获取用户信息")
    @GetMapping("/{id}")
    public Result<UserVO> getUserInfo(@PathVariable Long id) {
        // Controller 层不再关心数据是如何查出来的，只调用 Service 提供的方法
        return Result.success(userService.getUserInfoById(id));
    }

    @Operation(summary = "获取所有用户列表")
    @GetMapping
    public Result<List<UserVO>> listUsers() {
        return Result.success(userService.listAllUsers());
    }

    @Operation(summary = "创建新用户")
    @PostMapping
    public Result<UserVO> createUserInfo(@RequestBody @Valid UserDTO userDTO) {
        return Result.success(userService.createUser(userDTO));
    }

    @Operation(summary = "更新用户信息")
    @PutMapping("/{id}")
    public Result<UserVO> updateUserInfo(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
        return Result.success(userService.updateUser(id, userDTO));
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteUserInfo(@PathVariable Long id) {
        return Result.success(userService.deleteUser(id));
    }
}