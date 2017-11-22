package com.dream.base.service;

import java.util.Map;

import com.dream.base.entity.User;
import com.dream.util.NoteResult;

public interface MeunService {
	public NoteResult findAll();
	public NoteResult findById(String userId);
	public NoteResult cheakUser(Map<String,String> map);
	public NoteResult insert(User user);
	public NoteResult update(User user);
}
