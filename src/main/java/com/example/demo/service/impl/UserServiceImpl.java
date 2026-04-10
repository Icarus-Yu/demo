package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.model.entity.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.vo.UserVO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
//@service 是Spring框架的专属注解,扫描到这里时会对它进行实例化,并放入Ioc容器中进行统一管理
//@Autowired private UserService userService; 这个代码会让产生一个对象,就是从ioc仓库中找的
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
//extends ServiceImpl<UserMapper,User>
//泛型 <UserMapper, User>： 虽然父类很牛，但它不知道你要操作哪张表。所以你通过尖括号（泛型）告诉它两个关键信息：
//UserMapper：告诉它用哪个 Mapper 接口去连数据库。
//User：告诉它查出来的数据要包装成哪个实体类的样子。
    //implements UserService (签订“契约”)//作用： implements 表示实现一个接口。UserService 接口里之前定义了一个方法 User getUserInfoById(Long id);，就相当于签了一份合同：“我承诺会提供一个通过 ID 查用户信息的方法”。
    //意义： 这样写实现了规范与实现分离。Controller 只管叫人干活（认接口），而不管活具体是怎么干的（不关心实现类）。

    @Override
    public UserVO getUserInfoById(Long id) {
        // 这里可以加入更复杂的业务逻辑，比如判断用户是否被封禁，或者关联查询其他信息
        // 目前仅做简单的透传查询
        User user = this.getById(id);
        if (user == null) {
            return null;
        }
        return new UserVO(user.getId(), user.getName(), user.getRole());
    }

    @Override
    public UserVO createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setRole(userDTO.role());
        this.save(user);
        return new UserVO(user.getId(), user.getName(), user.getRole());
    }
}