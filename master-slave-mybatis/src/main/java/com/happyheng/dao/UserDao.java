package com.happyheng.dao;

import com.happyheng.Mapper.UserMapperMapper;
import com.happyheng.datasource.DataSourceProxy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * Created by happyheng on 17/1/16.
 */
@Service
public class UserDao {

    @Resource
    private UserMapperMapper userMapperMapper;


    public Integer getIdByName(String name) {

        // 1.设置为从数据库
        DataSourceProxy.setDataSource(DataSourceProxy.DataSourceEnum.SLAVE);

        // 2.访问数据库
        return userMapperMapper.getIdByName(name);
    }

}
