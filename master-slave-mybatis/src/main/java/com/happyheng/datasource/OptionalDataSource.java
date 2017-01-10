package com.happyheng.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * Created by happyheng on 17/1/10.
 */
public class OptionalDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}
