package com.yun.entity;

public class ChatEntity {
	private String Image;
	private String Name;
	private String Date;
	private String LastS;
	public ChatEntity(String string, String string2, String string3,String string4) {
		// TODO Auto-generated constructor stub
		Name=string;
		LastS=string2;
		Date=string3;
		Image=string4;
	}public ChatEntity() {
		// TODO Auto-generated constructor stub
		Name="";
		LastS="";
		Date="";
		Image="";
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getLastS() {
		return LastS;
	}
	public void setLastS(String lastS) {
		LastS = lastS;
	}
	
	

}
