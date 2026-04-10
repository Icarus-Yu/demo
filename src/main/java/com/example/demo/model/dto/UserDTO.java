package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户数据传输对象 (Request)
 * 使用 Java 21 Record 特性
 */
@Schema(description = "用户创建请求参数")
public record UserDTO(
    @Schema(description = "用户名", example = "张三")
    String name,
    
    @Schema(description = "用户角色", example = "Java实习生")
    String role
) {}