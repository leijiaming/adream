package com.dream.base.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dream.base.service.UserService;
import com.dream.util.NoteResult;

@Controller("loginController")
public class LoginController {
		@Resource(name="userService")
		private UserService userService;
		
		@RequestMapping("/login.do")
		@ResponseBody
		public ModelAndView  login(HttpServletRequest req, HttpServletResponse resp){
			ModelAndView mv = new ModelAndView();
	        //封装要显示到视图的数据
	        mv.addObject("msg","hello myfirst mvc");
	        //视图名
	        mv.setViewName("WEB-INF/jsp/login");
	        return mv;
		}
		
		@RequestMapping("/loginSuccess.do")
		@ResponseBody
		public ModelAndView  loginSuccess(HttpServletRequest req, HttpServletResponse resp){
			ModelAndView mv = new ModelAndView();
	        mv.setViewName("common/main");
	        return mv;
		}
}
