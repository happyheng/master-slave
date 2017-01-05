package com.happyheng.dao.proxy;

import com.happyheng.connection.ConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Connection;

/**
 * 数据库代理
 */
@Service
public class DataSourceProxy {

    ThreadLocal<String> dataSourceThreadLocal = new ThreadLocal<>();

    public static final String MASTER = "master";
    public static final String SLAVE = "slave";

    @Resource
    private ConnectionFactory connectionFactory;

    /**
     * 设置当前线程的数据库Mode
     */
    public void setMode(String dataMode) {
        dataSourceThreadLocal.set(dataMode);
    }

    /**
     * 得到当前数据库Mode
     */
    public String getMode() {
        return dataSourceThreadLocal.get();
    }

    /**
     * 根据当前Mode得到Connection连接对象
     */
    public Connection getThreadConnection() {

        // 1.判断当前是从数据还是主数据库,默认是主数据库
        String mode = getMode();
        if (!StringUtils.isEmpty(mode) && SLAVE.equals(mode)) {

            // y1.如果是从数据库,那么使用随机数的形式来得到从数据库连接
            double random = Math.random();
            int index = (int) (random * connectionFactory.getSlaveDataSourceSize());

            System.out.println("----使用的为第" + (index + 1) + "从数据库----");

            return connectionFactory.getSlaveConnection(index);
        } else {

            System.out.println("----使用的为主数据库----");

            // f1.如果是主数据库,因为只有一个,所以直接获取即可
            return connectionFactory.getMasterConnection();
        }

    }

}
