package com.happyheng.Controller;

import com.happyheng.dao.UserDao;
import com.happyheng.entity.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户相关Controller
 * Created by happyheng on 17/1/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    /**
     * 查询用户Id
     */
    @RequestMapping("/getId")
    public String getIdByName(String name) {

        return String.valueOf(userDao.getIdByName(name));
    }


    /**
     * 增加用户
     */
    @RequestMapping("/insertUser")
    public String insertUser(People people) {

        return "增加的主键为" + userDao.insertUser(people);
    }

}
