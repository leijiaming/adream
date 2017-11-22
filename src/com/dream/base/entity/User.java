package com.dream.base.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String user_id;//用户id
	private String user_name;//用户名
	private String password;//用户密码
	private Integer state;//状态
	private Integer user_role;//角色
	private String remarks;//备注
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getUser_role() {
		return user_role;
	}
	public void setUser_role(Integer user_role) {
		this.user_role = user_role;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public User() {
	}
	public User(String user_id, String user_name, String password,
			Integer state, Integer user_role, String remarks) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.state = state;
		this.user_role = user_role;
		this.remarks = remarks;
	}
}