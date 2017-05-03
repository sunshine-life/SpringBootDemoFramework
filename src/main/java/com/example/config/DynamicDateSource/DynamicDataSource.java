package com.example.config.DynamicDateSource;

/**
 * 定义 DynamicDataSource，继承AbstractRoutingDataSource
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSources temp = DataSourceTypeManager.get();
        return DataSourceTypeManager.get();
    }
}
