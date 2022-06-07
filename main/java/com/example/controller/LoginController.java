package com.example.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Enitity.User;
import com.example.controller.form.LoginForm;
import com.example.service.LoginService;
import com.example.util.ParamUtil;

@Controller
public class LoginController {
	
	 @Autowired
	 MessageSource messageSource;
	 
	 @Autowired
	 LoginService loginService;
	
	@RequestMapping("/login")
    public String login(@ModelAttribute("login") LoginForm form, Model model) {
    	
        return "login";
    }
	
	@RequestMapping(value = "/login", params = "login", method = RequestMethod.GET)
    public String resultlogin(@Validated@ModelAttribute("login") LoginForm form, BindingResult bindingResult, Model model) {
    	
    	String logid = form.getLogId();
    	String pass = form.getPass();
    	
    	if (ParamUtil.isNullOrEmpty(logid) && ParamUtil.isNullOrEmpty(pass)) {		
			return "login";			
		}else if(ParamUtil.isNullOrEmpty(logid)) {
			return "login";
		}if(ParamUtil.isNullOrEmpty(pass)){
			return "login";
		}  	
		User user = loginService.login(logid, pass);
		
		if(user == null) {		
			 String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
			 model.addAttribute("msg", errMsg);
			 return "login";
		}else{	
			Integer role = user.getRole();
			System.out.println(role);
			
			if(role == 1) {
			model.addAttribute("name", user.getName());
			return "menu";
			}
			return "menu2";
		}      
    }
	
	@RequestMapping(value = "/login", params = "insert", method = RequestMethod.GET)
    public String resultLoginInsert(@Validated@ModelAttribute("login") LoginForm form, BindingResult bindingResult, Model model) {
		String logid = form.getLogId();
    	String pass = form.getPass();
    	
    	if (ParamUtil.isNullOrEmpty(logid) && ParamUtil.isNullOrEmpty(pass)) {		
			return "login";			
		}else if(ParamUtil.isNullOrEmpty(logid)) {
			return "login";
		}if(ParamUtil.isNullOrEmpty(pass)){
			return "login";
		} 
		
		loginService.logininsert(logid, pass);
		
		model.addAttribute("msg", "登録完了");
		
		
			return "login";
		
	}
	
}