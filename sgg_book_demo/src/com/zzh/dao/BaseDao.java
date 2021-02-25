package com.zzh.dao;

import com.zzh.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    /*
    * 使用dbuitls操作操作数据库
    * */
    private QueryRunner queryRunner = new QueryRunner();

    //返回-1更新失败，成功返回影响的行数

    /**
     * 增删改都是这个方法
     * @param sql sql语句
     * @param args sql参数
     * @return 更新是否成功
     */
    public int update(String sql,Object...args){
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    //查询一条数据

    /**
     *
     * @param type 泛型对应的字节码类型
     * @param sql sql语句
     * @param param sql参数
     * @param <T> 泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object...param){
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
    //查询多个数据

    /**
     * 查询多个值的集合
     * @param type 泛型对应的字节码类型
     * @param sql sql语句
     * @param param sql参数
     * @param <T> 泛型
     * @return 返回list集合
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object...param){
        Connection conn = JdbcUtils.getConn();
        try {
            return    queryRunner.query(conn, sql, new BeanListHandler<T>(type), param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回一行一列的数据 比如统计
     * @param sql sql语句
     * @param param sql中的参数
     * @param <T> 泛型
     * @return
     */
    public<T> Object queryForSigleValue(String sql, Object...param){
         Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(),param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
