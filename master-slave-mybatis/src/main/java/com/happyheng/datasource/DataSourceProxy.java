package com.happyheng.datasource;

/**
 * 数据源配置
 * Created by happyheng on 17/1/15.
 */
public class DataSourceProxy {

    private static ThreadLocal<DataSourceEnum> threadLocal = new ThreadLocal<>();

    public enum DataSourceEnum {
        MASTER,
        SLAVE
    }

    /**
     * 为当前线程设置数据源
     */
    public static void setDataSource(DataSourceEnum sourceEnum) {
        threadLocal.set(sourceEnum);
    }

    public static DataSourceEnum getDataSource() {
        return threadLocal.get();
    }

}
