package com.inq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String to, String subject, String body) {
	    boolean isSent = false;

	    try {
	        MimeMessage mime = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mime);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(body, true); 
	        mailSender.send(mime);
	        isSent = true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSent;
	}

}
