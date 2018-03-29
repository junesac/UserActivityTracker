package com.toptal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toptal.model.UserRole;
import com.toptal.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/getAllRoles", method = RequestMethod.GET, produces = "application/json")
	public List<UserRole> getUserActivities() {
		return roleService.getAllRoles();
	}

}
