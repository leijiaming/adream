package com.dream.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dream.base.entity.User;


public interface UserDao {
	public List<User> findAll();
	public User findById(@Param("userId")String userId);
	public int cheakUser(Map<String,String> map);
	public int insert(User user);
	public int update(User user);
}
