package com.happyheng.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class ConnectionFactory {

    @Autowired
    private DataSource masterDataSource;

    @Autowired
    private DataSource slaveDataSource1;

    @Autowired
    private DataSource slaveDataSource2;

    private List<DataSource> slaveDataSourceList;

    private int slaveDataSourceSize;


    @PostConstruct
    private void init() {
        slaveDataSourceList = new ArrayList<>();
        slaveDataSourceList.add(slaveDataSource1);
        slaveDataSourceList.add(slaveDataSource2);

        slaveDataSourceSize = slaveDataSourceList.size();
    }


    /**
     * 得到主数据的连接
     */
    public Connection getMasterConnection() {
        return getConnection(masterDataSource);
    }

    /**
     * 得到从数据库的连接数量
     */
    public int getSlaveDataSourceSize() {
        return slaveDataSourceSize;
    }

    /**
     * 得到从数据n的连接
     */
    public Connection getSlaveConnection(int index){
        return getConnection(slaveDataSourceList.get(index));
    }


    private Connection getConnection(DataSource dataSource){

        Connection connection = null;
        try {
            Class.forName(dataSource.getDriver());

            connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUser(), dataSource.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
