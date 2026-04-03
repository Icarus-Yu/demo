package com.example.demo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
@TableName("sys_user")
public class User
{
    @TableId
    private Long id;
    private String name;
    private String role;

    public User (Long id ,String name ,String role)
    {
      this.id=id;
      this.name= name ;
      this .role=role;
    }
    public Long getId(){return id; }
    public String getName(){return name;}
    public String getRole(){ return role;}


}
