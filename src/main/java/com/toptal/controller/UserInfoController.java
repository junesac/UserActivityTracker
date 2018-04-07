package com.toptal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toptal.model.UserInfo;
import com.toptal.service.UserInfoService;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	@Qualifier(value = "userInfoService")
	private UserInfoService userInfoService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public List<UserInfo> getAllUsers() {
		return userInfoService.getAllUsers();
	}

	@RequestMapping(value = "/getUserByUserId/{id}", method = RequestMethod.GET, produces = "application/json")
	public UserInfo getUserByUserId(@PathVariable String id) {
		return userInfoService.getUserByUserId(Long.parseLong(id));
	}
	
	@RequestMapping(value = "/getUserByName", method = RequestMethod.GET, produces = "application/json")
	public UserInfo getUserByName(@RequestParam String userName) {
		return userInfoService.getUserByName(userName);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public UserInfo login(@RequestBody UserInfo userInfo) {
		return userInfoService.login(userInfo);
	}
	

	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public UserInfo createUser(@RequestBody UserInfo user) {
		return userInfoService.createUser(user);
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public UserInfo updateUser(@RequestBody UserInfo user, @PathVariable Long id) {
		return userInfoService.updateUser(user, id);
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUser(@PathVariable Long id) {
		userInfoService.deleteUser(id);
	}

}
