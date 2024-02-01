package com.example.testboard2.testboard2.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/*
 * @Configuration : 스프링부트 환경설정 클래스임을 명시. 자동으로 빈 등록
 *  이 어노테이션이 붙게되면 @ComponentScan이 스캔할 때 이 클래스에 @Bean으로 지정한 모든 번들도 IoC(Inversion of Control) 컨테이너에 등록.
 */
@Configuration
@PropertySource("classpath:/applicaton.properties") //classpath:/ => resources/
public class DBConfiguration {
    
    public HikariConfig hikariConfig(){
        
        return new HikariConfig();
    }

    public DataSource dataSource() {

        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println(dataSource.toString());

        return dataSource;
    }

    //MyBatis 설정 1 : SqlSessionFactory <-- SqlSessionFactoryBean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        return factoryBean.getObject();
    }

    //MyBatis 설정 2 : SqlSessionTemplate <-- SqlSessionFactory
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {

        return new SqlSessionTemplate(sqlSessionFactory());
    }


}
