package com.happyheng.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by happyheng on 17/1/4.
 */
@Service
public class ConnectionFactory {

    private DataSource masterDataSource;

    private List<DataSource> slaveDataSourceList;

    private int slaveDataSourceSize;


    @Autowired
    private Environment environment;


    @PostConstruct
    private void init() {

        masterDataSource = new DataSource();
        masterDataSource.driver = environment.getProperty("master.driver");
        masterDataSource.url = environment.getProperty("master.dburl");
        masterDataSource.user = environment.getProperty("master.user");
        masterDataSource.password = environment.getProperty("master.password");

        DataSource slaveDataSource1 = new DataSource();
        slaveDataSource1.driver = environment.getProperty("slave1.driver");
        slaveDataSource1.url = environment.getProperty("slave1.dburl");
        slaveDataSource1.user = environment.getProperty("slave1.user");
        slaveDataSource1.password = environment.getProperty("slave1.password");

        DataSource slaveDataSource2 = new DataSource();
        slaveDataSource2.driver = environment.getProperty("slave2.driver");
        slaveDataSource2.url = environment.getProperty("slave2.dburl");
        slaveDataSource2.user = environment.getProperty("slave2.user");
        slaveDataSource2.password = environment.getProperty("slave2.password");

        slaveDataSourceList = new ArrayList<DataSource>();
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
     * 得到从数据n的连接
     */
    public Connection getSlave1Connection(int index){
        return getConnection(slaveDataSourceList.get(index));
    }


    private Connection getConnection(DataSource dataSource){

        Connection connection = null;
        try {
            Class.forName(dataSource.driver);

            connection = DriverManager.getConnection(dataSource.url, dataSource.user, dataSource.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }





    class DataSource{

        public String driver;

        public String url;

        public String user;

        public String password;

    }

}
