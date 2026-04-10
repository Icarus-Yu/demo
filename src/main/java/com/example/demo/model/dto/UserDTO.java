package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 用户请求参数 (Request)
 */
@Schema(description = "用户请求参数")
public record UserDTO(
    @Schema(description = "用户名", example = "张三")
    @NotBlank(message = "用户名不能为空")
    @Size(min = 2, max = 20, message = "用户名长度需在2-20之间")
    String name,
    
    @Schema(description = "用户角色", example = "Java实习生")
    @NotBlank(message = "用户角色不能为空")
    String role
) {}