//내가 생성한 파일임
package com.web.first.my.group.PPackage.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration  //스프링은 @Configuration이 지정된 클래스를 자바 기반의 설정 파일로 인식합니다.
@PropertySource("classpath:/application.properties") //해당 클래스에서 참조할 properties 파일의 위치를 지정합니다.
public class DatabaseConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    //@PropertySource("classpath:/application.properties")에서 정의한
    //spring.datasource.hikari로 시작하는 설정을 모두 읽어들여서 해당 메서드에 매핑(바인딩)시전함.
    public HikariConfig hikariConfig() {    	
        return new HikariConfig();    	
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws Exception {  //DataSource는 커넥션풀을 지원하기위한 인터페이스임.
        return new HikariDataSource(hikariConfig());       
    }

    
    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")  //①
    public org.apache.ibatis.session.Configuration mybatisConfig(){  	    	
        return new org.apache.ibatis.session.Configuration();   //②
    }    
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
        sqlSessionFactoryBean.setConfiguration(mybatisConfig()); 
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean    
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }    
}

