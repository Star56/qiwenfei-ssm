package com.qiwenfei.note.template.dao;

import com.qiwenfei.note.template.JdbcTemplate;
import com.qiwenfei.note.template.RowMapper;
import com.qiwenfei.note.template.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 2018-05-27
 * sunshine
 * 不用继承，使用组合，降低耦合性
 */
public class MemberDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query()throws Exception{
        String sql = "select id,name from member ";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rownum) throws Exception{
                Member member = new Member();
                member.setId(resultSet.getLong("id"));
                member.setName(resultSet.getString("name"));
                return member;
            }
        },null);
    }
}
