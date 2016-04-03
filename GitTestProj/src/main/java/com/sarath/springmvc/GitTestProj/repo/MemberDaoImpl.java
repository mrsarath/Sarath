package com.sarath.springmvc.GitTestProj.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import com.sarath.springmvc.GitTestProj.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao
{   
	@Autowired
	DataSource dataSource;
	
    public Member findById(Long id)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        		//return em.find(Member.class, id);
        
        Member emp = jdbcTemplate.queryForObject("", new Object[]{id}, new RowMapper<Member>(){
        	 
            @Override
            public Member mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	Member emp = new Member();
                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                return emp;
            }});
         
        return emp;

    }

    public Member findByEmail(String email)
    {
       return null;
    }

    public List<Member> findAllOrderedByName()
    {
    	return null;    	
    }

    public void register(Member member)
    {
        //em.persist(member);
        return;
    }
}
