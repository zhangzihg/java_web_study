package com.zzh.test;

import com.zzh.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class DemoTest {
    @Test
    public void test1(){
        for(int i=0; i<100; i++){
            Connection conn = JdbcUtils.getConn();
            System.out.println(conn);
        }

    }
}
