package com.leyou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/18
 * @Version V1.0
 **/
@RestController
public class HelloController {
    @GetMapping("hello")
    public String testSpring(){
        return "hello spring boot80";
    }
}
