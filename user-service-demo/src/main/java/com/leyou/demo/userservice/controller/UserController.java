package com.leyou.demo.userservice.controller;

import com.leyou.demo.userservice.instance.User;
import com.leyou.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/19
 * @Version V1.0
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public User queryByid(@PathVariable("id") long id){
        return userService.selectByPrimaryKey(id);
    }
}
