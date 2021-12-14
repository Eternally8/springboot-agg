package com.robben.sharding.utils;

/**
 * Description： TODO
 * Author: robben
 * Date: 2021/11/16 16:58
 */
import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;


public class DataSourceUtil {

    public static DataSource createDataSource(final String driverClass, final String url, String userName, String passWord) {
        final DruidDataSource result = new DruidDataSource();
        result.setDriverClassName(driverClass);
        result.setUrl(url);
        result.setUsername(userName);
        result.setPassword(passWord);
        result.setInitialSize(5);
        result.setMinIdle(5);
        result.setMaxActive(20);
        result.setMaxWait(60000);
        result.setTimeBetweenEvictionRunsMillis(60000);
        result.setMinEvictableIdleTimeMillis(30000);

        return result;
    }

}
