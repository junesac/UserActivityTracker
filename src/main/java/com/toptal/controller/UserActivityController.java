package com.toptal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toptal.model.Filter;
import com.toptal.model.UserActivity;
import com.toptal.service.UserActivityService;

@RestController
@RequestMapping("/userActivity")
public class UserActivityController {

	@Autowired
	@Qualifier(value = "userActivityService")
	private UserActivityService userActivityService;

	@RequestMapping(value = "/getUserActivities/{userId}", method = RequestMethod.POST, produces = "application/json")
	public List<UserActivity> getUserActivities(@PathVariable Long userId, @RequestBody Filter filter) {
		System.out.println("Filter in controller : " + filter);
		return userActivityService.getUserActivities(userId, filter);
	}

	@RequestMapping(value = "/getUserActivitiesByUserId/{id}", method = RequestMethod.GET, produces = "application/json")
	public UserActivity getUserActivitiesByUserId(@PathVariable String id) {
		return userActivityService.getUserActivitiesByUserId(Long.parseLong(id));
	}

	@RequestMapping(value = "/createUserActivity/{userId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public UserActivity createUserActivity(@PathVariable Long userId, @RequestBody UserActivity userActivity) {
		return userActivityService.createUserActivity(userId, userActivity);
	}

	@RequestMapping(value = "/updateUserActivity/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public UserActivity updateUserActivity(@RequestBody UserActivity userActivity, @PathVariable Long id) {
		return userActivityService.updateUserActivity(userActivity, id);
	}

	@RequestMapping(value = "/deleteUserActivity/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUserActivity(@PathVariable Long id) {
		userActivityService.deleteUserActivity(id);
	}
}
