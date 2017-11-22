package com.dream.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.base.entity.User;
import com.dream.base.service.UserService;
import com.dream.util.NoteResult;


@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;

	@RequestMapping("/findAll.do")
	@ResponseBody
	public NoteResult findAll(){
		return userService.findAll();
	}
	@RequestMapping("/cheakUser.do")
	@ResponseBody
	public NoteResult cheakUser(String userName,String pwd){
		Map<String,String> map=new HashMap<String,String>();
		map.put("userName", userName);
		map.put("pwd", pwd);
		if(userName==null||"".equals(userName)){
			return new NoteResult(2,"用户名为空或参数名错误",null,null);
		}
		if(pwd==null||"".equals(pwd)){
			return new NoteResult(2,"密码为空或参数名错误",null,null);
		}
		return userService.cheakUser(map);
	}
	@RequestMapping("/findById.do")
	@ResponseBody
	public NoteResult findById(String userId){
		return userService.findById(userId);
	}
	@RequestMapping("/insert.do")
	@ResponseBody
	public NoteResult insert(HttpServletRequest request,HttpServletResponse response,
			 String user_name,
			 String password,
			 Integer state,
			 Integer user_role,
			 String remarks
			 ){
		User user=new User(null, user_name, password, state, user_role, remarks);
		return userService.insert(user);
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult update(HttpServletRequest request,HttpServletResponse response,
			 String user_id,
			 String user_name,
			 String password,
			 Integer state,
			 Integer user_role,
			 String remarks){
		User user=new User(user_id, user_name, password, state, user_role, remarks);
		return userService.update(user);
	}
}
