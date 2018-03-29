package com.toptal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.toptal.model.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserInfo> getAllUsers() {
		List<UserInfo> users = jdbcTemplate.query(
				"SELECT u.userid, u.userName, r.rolename FROM users u, user_role ur, role r where r.rid=ur.rid and ur.userid = u.userid",
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return users;
	}

	@Override
	public UserInfo getUserByName(String userName) {
		return null;
	}

	@Override
	public UserInfo createUser(UserInfo user) {

		Long id = jdbcTemplate.queryForObject("select max(userid) from users", Long.class);
		if (id == null) {
			id = 1l;
		}
		user.setUserId(id + 1);

		jdbcTemplate.update("INSERT INTO users (userid, username, password) VALUES (?, ?, ?)", user.getUserId(),
				user.getUserName(), user.getPassword());

		jdbcTemplate.update("INSERT INTO user_role (userid, rid) VALUES (?, ?)", user.getUserId(), user.getrId());

		System.out.println("Person Added!!");
		return user;
	}

	@Override
	public UserInfo updateUser(UserInfo user, Long id) {
		jdbcTemplate.update("update users set username = ? WHERE userid= ? ", user.getUserName(), id);
		jdbcTemplate.update("update user_role set rid = ? WHERE userid= ? ", user.getrId(), id);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		jdbcTemplate.update("DELETE from users WHERE userid = ? ", id);
		jdbcTemplate.update("DELETE from user_role WHERE userid = ? ", id);
		System.out.println("Person Deleted!!");
	}

	@Override
	public UserInfo getUserByUserId(long id) {

		UserInfo userInfo = jdbcTemplate.queryForObject(
				"SELECT u.userid, u.userName, r.rolename, ur.rid FROM users u, user_role ur, role r where r.rid=ur.rid and ur.userid = u.userid and u.userid = ?",
				new Object[] { id }, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return userInfo;
	}
}