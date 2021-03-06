package com.coral.database.test.mybatis.config.datasource.tertiary;

import com.coral.database.test.mybatis.config.datasource.MybatisSessionFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author huss
 * @version 1.0
 * @className TertiaryMybatisPlusConfig
 * @description
 * @date 2021/5/21 16:36
 */
@MapperScan(basePackages = "com.coral.**.tertiary.**.mapper", sqlSessionTemplateRef = "tertiarySqlSessionTemplate")
@Configuration
public class TertiaryDatsSourceConfig {
    /**
     * 本数据源扫描的mapper路径
     */
    static final String MAPPER_LOCATION = "classpath*:mapper/tertiary/*.xml";

    @Autowired
    private MybatisSessionFactory mybatisSessionFactory;


    @Bean(name = "tertiarySqlSessionFactory")
    public SqlSessionFactory tertiarySqlSessionFactory(@Qualifier("dataSourceTertiary") DataSource dataSource) throws Exception {
        return mybatisSessionFactory.sqlSessionFactory(dataSource, MAPPER_LOCATION);
    }

    /**
     * 创建SqlSessionTemplate
     */
    @Bean(name = "tertiarySqlSessionTemplate")
    public SqlSessionTemplate tertiarySqlSessionTemplate(@Qualifier("tertiarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
