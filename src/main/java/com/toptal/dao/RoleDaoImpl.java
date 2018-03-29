package com.toptal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.toptal.model.UserRole;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserRole> getAllRoles() {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<UserRole> userRoles = jdbcTemplate.query("SELECT * FROM role", new BeanPropertyRowMapper(UserRole.class));
		System.out.println(userRoles);
		return userRoles;
	}

}
