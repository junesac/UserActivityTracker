package com.toptal.dao;

import java.util.List;

import com.toptal.model.UserInfo;

public interface UserInfoDao {

	List<UserInfo> getAllUsers();

	UserInfo getUserByName(String userName);

	UserInfo createUser(UserInfo user);

	UserInfo updateUser(UserInfo user, Long id);

	void deleteUser(Long id);

	UserInfo getUserByUserId(long id);

	UserInfo login(UserInfo userInfo);

}
