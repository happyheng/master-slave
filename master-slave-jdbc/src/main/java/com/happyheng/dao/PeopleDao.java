package com.happyheng.dao;

import com.happyheng.dao.proxy.DataSourceProxy;
import com.happyheng.entity.People;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Created by happyheng on 17/1/4.
 */
@Service
public class PeopleDao {

    @Resource
    private DataSourceProxy dataSourceProxy;

    //@DataSource(DataSourceProxy.MASTER)
    public People getPeopleByName(String name) {

        People people = new People();
        try {
            // 设置为从数据库
            dataSourceProxy.setMode(DataSourceProxy.SLAVE);

            Connection connection = dataSourceProxy.getThreadConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM people WHERE name = ?;");

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                people.setName(resultSet.getString("name"));
                people.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }


}
