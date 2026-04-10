package com.example.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data // 自动生成 getter、setter、toString、equals、hashCode
@NoArgsConstructor // 自动生成无参构造函数
@AllArgsConstructor // 自动生成全参构造函数
@TableName("sys_user") // 指定数据库表名
public class User {

    @TableId // 标记主键
    private Long id;

    private String name;

    private String role;

}