package com.happyheng.dao;

import com.happyheng.Mapper.UserMapper;
import com.happyheng.datasource.DataSourceProxy;
import com.happyheng.entity.People;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * Created by happyheng on 17/1/16.
 */
@Service
public class UserDao {

    @Resource
    private UserMapper userMapper;


    public Integer getIdByName(String name) {

        // 1.设置为从数据库
        DataSourceProxy.setDataSource(DataSourceProxy.DataSourceEnum.SLAVE);

        // 2.访问数据库
        return userMapper.getIdByName(name);
    }

    public Integer insertUser(People people) {

        // 1.设置为从数据库
        DataSourceProxy.setDataSource(DataSourceProxy.DataSourceEnum.MASTER);

        // 2.访问数据库
        userMapper.insertUser(people);
        return people.getId();
    }

}
