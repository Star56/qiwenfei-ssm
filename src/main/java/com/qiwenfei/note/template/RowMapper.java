package com.qiwenfei.note.template;

import java.sql.ResultSet;

/**
 * 2018-05-27
 * sunshine
 */
public interface RowMapper<T> {

    public  T mapRow(ResultSet resultSet,int rownum)throws Exception;

}
