package com.toptal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toptal.dao.UserInfoDao;
import com.toptal.model.UserInfo;

@Service("userInfoService")
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	public List<UserInfo> getAllUsers() {
		return userInfoDao.getAllUsers();
	}

	public UserInfo getUserByName(String userName) {
		return userInfoDao.getUserByName(userName);
	}

	public UserInfo createUser(UserInfo user) {
		return userInfoDao.createUser(user);
	}

	public UserInfo updateUser(UserInfo user, Long id) {
		return userInfoDao.updateUser(user, id);
	}

	public void deleteUser(Long id) {
		userInfoDao.deleteUser(id);
	}

	public UserInfo getUserByUserId(long id) {
		return userInfoDao.getUserByUserId(id);
	}

}
