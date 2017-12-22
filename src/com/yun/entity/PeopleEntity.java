package com.yun.entity;

public class PeopleEntity {
	private String userId;
	private String HeadImage;
	private String userName;
	private boolean isStar;

	public PeopleEntity(String s1, String s2,boolean star) {
		HeadImage = s2;
		userName = s1;
		isStar=star;
	}

	public String getUserId() {
		return userId;
	}

	public boolean isStar() {
		return isStar;
	}

	public void setStar(boolean isStar) {
		this.isStar = isStar;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHeadImage() {
		return HeadImage;
	}

	public void setHeadImage(String headImage) {
		HeadImage = headImage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
