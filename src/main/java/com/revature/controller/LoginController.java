package com.revature.controller;

import static com.revature.util.LoggerUtil.log;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
	private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	private Session sess;
	private Transaction tx;
	
	private void beginSession() {
		sess = sf.openSession();
		tx = sess.beginTransaction();
	}
	
	private void endSession() {
		tx.commit();
		sess.close();
	}
	
	@GetMapping
	public String loginGet() {
		log.debug("Hello, get.");
		return "Login Getto!";
	}
	
	@PostMapping//(consumes="application/json")
	public User loginPost() {
		beginSession();
		User user = sess.get(User.class, "ricky@email.com");
		endSession();
		log.debug(user);
		return user;
	}
}