package com.toptal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.toptal.exception.UserInfoException;
import com.toptal.model.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserInfo> getAllUsers() {
		List<UserInfo> users = jdbcTemplate.query(
				"SELECT u.userid, u.userName, r.rolename, us.setting as userSetting FROM users u, user_role ur, user_setting us, role r where r.rid=ur.rid and ur.userid = u.userid and ur.userid = us.userid",
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return users;
	}

	@Override
	public UserInfo getUserByName(String userName) {
		return null;
	}

	@Override
	public UserInfo createUser(UserInfo user) {

		checkUserNameAvailable(user.getUserName());

		Long id = jdbcTemplate.queryForObject("select max(userid) from users", Long.class);
		if (id == null) {
			id = 1l;
		}
		user.setUserId(id + 1);

		jdbcTemplate.update("INSERT INTO users (userid, username, password) VALUES (?, ?, ?)", user.getUserId(),
				user.getUserName(), user.getPassword());

		jdbcTemplate.update("INSERT INTO user_role (userid, rid) VALUES (?, ?)", user.getUserId(), user.getrId());

		jdbcTemplate.update("INSERT INTO user_setting (userid, setting) VALUES (?, ?)", user.getUserId(),
				user.getUserSetting());

		System.out.println("Person Added!!");
		return user;
	}

	private void checkUserNameAvailable(String userName) {

		int count = jdbcTemplate.queryForObject("SELECT count(1) FROM users u where lower(u.userName) = ? ",
				new Object[] { userName.toLowerCase() }, Integer.class);

		System.out.println("count : " + count);

		if (count != 0) {
			throw new UserInfoException("User Already exist.");
		}
	}

	@Override
	public UserInfo updateUser(UserInfo user, Long id) {
		jdbcTemplate.update("update users set username = ? WHERE userid= ? ", user.getUserName(), id);
		jdbcTemplate.update("update user_role set rid = ? WHERE userid= ? ", user.getrId(), id);
		jdbcTemplate.update("update user_setting set setting = ? WHERE userid= ? ", user.getUserSetting(), id);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		jdbcTemplate.update("DELETE from users WHERE userid = ? ", id);
		jdbcTemplate.update("DELETE from user_role WHERE userid = ? ", id);
		jdbcTemplate.update("DELETE from user_setting WHERE userid = ? ", id);
		System.out.println("Person Deleted!!");
	}

	@Override
	public UserInfo getUserByUserId(long id) {

		UserInfo userInfo = jdbcTemplate.queryForObject(
				"SELECT u.userid, u.userName, r.rolename, ur.rid, us.setting as userSetting FROM users u, user_setting us, user_role ur, role r where r.rid=ur.rid and ur.userid = u.userid and ur.userid = us.userid  and u.userid = ?",
				new Object[] { id }, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return userInfo;
	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		UserInfo result = jdbcTemplate.queryForObject(
				"SELECT u.userid, u.userName, r.rolename, ur.rid, us.setting as userSetting FROM users u, user_setting us, user_role ur, role r where r.rid=ur.rid and ur.userid = u.userid and ur.userid = us.userid  and lower(u.userName) = ? and u.password = ?",
				new Object[] { userInfo.getUserName().toLowerCase(), userInfo.getPassword() },
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return result;

	}
}