package com.dream.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.base.service.UserService;
import com.dream.util.NoteResult;

@Controller("meunController")
@RequestMapping("/meun")
public class MeunController {
	@Resource(name="userService")
	private UserService userService;

	@RequestMapping("/findAll.do")
	@ResponseBody
	public NoteResult findAll(){
		return userService.findAll();
	}
}
