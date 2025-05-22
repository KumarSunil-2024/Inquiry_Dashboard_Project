package com.inq.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inq.binding.LoginForm;
import com.inq.binding.SignUpForm;
import com.inq.binding.UnlockForm;
import com.inq.entity.UserDtls;
import com.inq.repo.UserDtlsRepo;
import com.inq.service.UserService;
import com.inq.util.EmailUtils;
import com.inq.util.PwdUtils;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDtlsRepo uRepo;
	
	@Autowired
	private EmailUtils sendMail;
	
	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signUp(SignUpForm form) {
		// TODO Auto-generated method stub
		UserDtls user=uRepo.findByEmail(form.getEmail());
		if(user!=null) {
			return false;
		}
		UserDtls entity=new UserDtls();
		BeanUtils.copyProperties(form, entity);
		String tempPwd=PwdUtils.generateRandomPwd();
		entity.setPwd(tempPwd);
		entity.setAccStatus("LOCKED");
		uRepo.save(entity);
		
		String to=form.getEmail();
		String subject="Unlock Your Account";
		StringBuffer text=new StringBuffer("");
		text.append("<h1>Use below temporary pwd to unlock your account</h1>");
		text.append("Temporary pwd : "+tempPwd);
		text.append("<br/>");
		text.append("<a href=\"unlock?email=" + to + "\">Click here to unlock Account</a>");
		sendMail.sendEmail(to, subject, text.toString());
		
		return false;
	}

	@Override
	public boolean unlockAccount(UnlockForm form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
