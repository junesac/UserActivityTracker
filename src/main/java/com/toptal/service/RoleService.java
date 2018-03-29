package com.toptal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toptal.dao.RoleDao;
import com.toptal.model.UserRole;

@Service("roleService")
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public List<UserRole> getAllRoles() {
		return roleDao.getAllRoles();
	}

}
