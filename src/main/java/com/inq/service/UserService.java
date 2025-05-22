package com.inq.service;

import com.inq.binding.LoginForm;
import com.inq.binding.SignUpForm;
import com.inq.binding.UnlockForm;

public interface UserService {

	public String login(LoginForm form);
	
	public boolean signUp(SignUpForm form);
	
	public boolean unlockAccount(UnlockForm form);
	
	public String forgotPwd(String email);
	
}
