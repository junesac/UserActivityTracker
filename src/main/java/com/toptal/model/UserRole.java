package com.toptal.model;

public class UserRole {

	private Long rid;
	private String rolename;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "UserRole [rid=" + rid + ", rolename=" + rolename + "]";
	}

}