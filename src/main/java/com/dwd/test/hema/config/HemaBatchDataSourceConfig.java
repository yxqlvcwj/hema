package com.dwd.test.hema.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = HemaBatchDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "hemaBatchDataSqlSessionFactory")
@PropertySource("classpath:application.properties")
public class HemaBatchDataSourceConfig {
    static final String PACKAGE="com.dwd.test.hema.mapper";
    static final String MAPPER_LOCATION="classpath:mybatis/*.xml";

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "hemaBatchDataSource")
    public DataSource hemaBatchDataSource()
    {
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean(name = "hemaBatchDataTransactionManager")
    public DataSourceTransactionManager hemaBatchDataTransactionManager()
    {
        return new DataSourceTransactionManager(hemaBatchDataSource());
    }
    @Bean(name = "hemaBatchDataSqlSessionFactory")
    public SqlSessionFactory hemaBatchDataSqlSessionFactory(@Qualifier("hemaBatchDataSource") DataSource hemaBatchDataSource)
        throws Exception{
        final SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(hemaBatchDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(HemaBatchDataSourceConfig.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }

}
