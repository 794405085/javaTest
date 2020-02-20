package com.leyou.demo.userservice.instance;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/19
 * @Version V1.0
 **/
public class User extends BasePojo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    // 用户名
    private String userName;

    // 密码
    private String password;

    // 姓名
    private String name;

    // 年龄
    private String age;

    // 性别，1男性，2女性
    private String sex;

    // 出生日期
    private Date birthday;


    // 备注
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
