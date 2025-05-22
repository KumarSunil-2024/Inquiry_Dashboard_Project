package com.inq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inq.binding.SignUpForm;
import com.inq.binding.UnlockForm;
import com.inq.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uSer;
	
	@PostMapping("/signup")
	public String handleSignUp(SignUpForm form) {
		boolean status=uSer.signUp(form);
		if(status) {
			
		}else {
			
		}
		return null;
	}
	
	@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email) {
		UnlockForm unlockFormObj=new UnlockForm();
		
		return "unlock";
	}
}
