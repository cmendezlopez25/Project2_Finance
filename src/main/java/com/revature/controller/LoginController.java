package com.revature.controller;

import static com.revature.util.LoggerUtil.log;

import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.util.SessionFactoryUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
	private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@GetMapping
	public String loginGet() {
		log.debug("Hello, get.");
		return "Login Getto!";
	}
	
	@PostMapping
	public String loginPost() {
		log.debug("Hello, post.");
		return "Login Postto!";
	}
}