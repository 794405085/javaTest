package com.leyou.demo.userservice.service;

import com.leyou.demo.userservice.Mapper.UserMapper;
import com.leyou.demo.userservice.instance.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/19
 * @Version V1.0
 **/
@Service(value = "userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectByPrimaryKey(long id) {
        return userMapper.selectById(id);
    }
}
