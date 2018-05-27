package com.qiwenfei.note.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 2018-05-27
 * sunshine
 * 模板模式：主要是流程的封装，调用的消费者只需根据需求重新个性化的方法
 *
 */
public class JdbcTemplate {
    private DataSource dataSource  ;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private Connection getConnection()throws Exception{
        return this.dataSource.getConnection();
    }

    private  PreparedStatement createPreparedStatement(Connection connection,String sql)throws Exception{
        return  connection.prepareStatement(sql);
    }
    public  ResultSet executeQuery(PreparedStatement ps,Object[] values)throws Exception{

         for (int i=0;i<values.length;i++){
             ps.setObject(i,values[i]);
         }
         return ps.executeQuery();
    }

    private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception{
        List<Object> rsList = new ArrayList<Object>();
        int rownum = 1 ;
        while (rs.next()){
            rsList.add(rowMapper.mapRow(rs,rownum++));
        }
        return rsList;
    }


    public List<?> executeQuery(String sql ,RowMapper<?> rowMapper,Object[] values){

        Connection connection = null ;
        try {
            //(1)获取连接
            connection = this.getConnection();
            //(2)创建语句集
            PreparedStatement ps = this.createPreparedStatement(connection,sql);
            //(3)执行语句集，并获取结果集
            ResultSet rs = this.executeQuery(ps,values);
            //(4)解析结果集
            List<?> resList = this.parseResultSet(rs,rowMapper);
            //(5)关闭结果集
            rs.close();
            //(6)关闭语句集
            ps.close();
            //(7)关闭连接

          return resList ;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null !=connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return new ArrayList();
    }


}
