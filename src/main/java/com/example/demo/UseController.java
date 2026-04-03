package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UseController
{
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public User getUserInfo( @RequestParam(value="id",defaultValue = "1")Long id)
    {
        return userMapper.selectById(id);
    }

}
