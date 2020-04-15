package cn.edu.tsu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Gregorio
 * @date 2020/4/13 10:50
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:jdbc.properties",encoding = "UTF-8")
public class MyConfiguration {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource jdbcDatasource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("mysql.url"));
        dataSource.setDriverClassName(environment.getProperty("mysql.driver.class"));
        dataSource.setUsername(environment.getProperty("mysql.username"));
        dataSource.setPassword(environment.getProperty("mysql.password"));
        return dataSource;
    }

    @Bean
    public TransactionManager transactionManager(){
        return new DataSourceTransactionManager(jdbcDatasource());
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(jdbcDatasource());
    }
}
