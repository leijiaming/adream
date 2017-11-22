package com.dream.base.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dream.base.dao.UserDao;
import com.dream.base.entity.User;
import com.dream.base.service.UserService;
import com.dream.util.NoteResult;
/**
 * 用户管理
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private static Logger logger=Logger.getLogger(UserServiceImpl.class.getName());
	@Resource(name="userDao")
	private UserDao userDao;
	public NoteResult findAll() {
		NoteResult nr=new NoteResult(2,"失败",null,null);
		List<User> list=userDao.findAll();
		if(list!=null){
			nr.setStatus(0);
			nr.setMsg("成功");
			nr.setData(list);
			nr.setInfo("findAll");
		}
		return nr;
	}
	public NoteResult findById(String userId) {
		NoteResult nr=new NoteResult(2,"失败",null,null);
		User user=userDao.findById(userId);
		if(user!=null){
			nr.setStatus(0);
			nr.setMsg("成功");
			nr.setData(user);
			nr.setInfo("findById");
		}
		return nr;
	}
	public NoteResult insert(User user) {
		NoteResult nr=new NoteResult(2,"失败",null,null);
		int num=userDao.insert(user);
		if(num>0){
			nr.setStatus(0);
			nr.setMsg("成功");
			nr.setData(num);
			nr.setInfo("insert");
		}
		return nr;
	}
	public NoteResult update(User user) {
		NoteResult nr=new NoteResult(2,"失败",null,null);
		int num=userDao.update(user);
		if(num>0){
			nr.setStatus(0);
			nr.setMsg("成功");
			nr.setData(num);
			nr.setInfo("update");
		}
		return nr;
	}
	public NoteResult cheakUser(Map<String, String> map) {
		NoteResult nr=new NoteResult(2,"未知失败",null,null);
		map.put("mark", "0");
		int num=userDao.cheakUser(map);
		if(num==0){
			nr.setStatus(1);
			nr.setMsg("此用户不存在");
			nr.setData(null);
			nr.setInfo("cheakUser");
			return nr;
		}
		map.put("mark", "1");
		num=userDao.cheakUser(map);
		if(num==0){
			nr.setStatus(3);
			nr.setMsg("密码错误！");
			nr.setData(null);
			nr.setInfo("cheakUser");
			return nr;
		}else if(num>0){
			nr.setStatus(0);
			nr.setMsg("登陆成功");
			nr.setData(null);
			nr.setInfo("loginSuccess.do");
			return nr;
		}
		return nr;
	}
}
