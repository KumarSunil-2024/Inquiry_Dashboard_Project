package com.inq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {

	@GetMapping("/dashboard")
	public String dashboardPage() {
		
		return null;
	}
	
	@GetMapping("/enquiry")
	public String addEnquiryPage() {
		
		return null;
	}
	
	@GetMapping("/enquires")
	public String viewEnquiryPage() {
		
		return null;
	}
	
}
