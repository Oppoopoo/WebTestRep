package com.web.first.my.group.PPackage;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import java.sql.Connection;
// 
//import javax.sql.DataSource;
// 
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
////import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
 
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration(classes = MyFirstWebApplicationTest001.class)
//@WebAppConfiguration
@SpringBootTest
public class MyFirstWebApplicationTest001 {
    
    @Autowired
    private DataSource ds; //작성
 
    @Test
    public void contextLoads() {
    }
 
    @Test
    public void testConnection() throws Exception{ //작성
        System.out.println("ds : "+ds);
        
        Connection con = ds.getConnection(); //ds(DataSource)에서 Connection을 얻어내고
        
        System.out.println("con : "+con); //확인 후
        
        con.close(); //close
    }
}