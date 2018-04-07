package com.toptal.model;

public class UserInfo {

	private Long userId;
	private String userName;
	private String password;
	private Long rId;
	private String roleName;
	private Long userSetting;

	public Long getUserSetting() {
		return userSetting;
	}

	public void setUserSetting(Long userSetting) {
		this.userSetting = userSetting;
	}

	public UserInfo() {

	}

	public UserInfo(Long userId, String userName, String password, Long rId, String roleName, Long userSetting) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.rId = rId;
		this.roleName = roleName;
		this.userSetting = userSetting;

	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", password=" + password + ", rId=" + rId
				+ ", roleName=" + roleName + ", userSetting=" + userSetting + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
