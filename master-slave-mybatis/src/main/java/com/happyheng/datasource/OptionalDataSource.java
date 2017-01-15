package com.happyheng.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * Created by happyheng on 17/1/10.
 */
public class OptionalDataSource extends AbstractRoutingDataSource {

    // 数据源
    private String masterDataSource = "masterDataSource";
    private String[] slaveDataSource = {"slaveDataSource1", "slaveDataSource2"};

    @Override
    protected Object determineCurrentLookupKey() {


        DataSourceProxy.DataSourceEnum dataSourceEnum = DataSourceProxy.getDataSource();

        if (dataSourceEnum == DataSourceProxy.DataSourceEnum.SLAVE) {

            double random = Math.random();
            int randomIndex = (int)(random * slaveDataSource.length);
            return slaveDataSource[randomIndex];
        } else {
            return masterDataSource;
        }
    }
}
