package com.leyou.demo.userservice.Mapper;

import com.leyou.demo.userservice.instance.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    public  User selectById(long id);
}
