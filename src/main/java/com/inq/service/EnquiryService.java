package com.inq.service;

import java.util.List;

import com.inq.binding.DashBoardResponse;
import com.inq.binding.EnquiryForm;
import com.inq.binding.EnquirySearchCriteria;

public interface EnquiryService {

	public List<String> getCourseNames();
	
	public List<String> getEnqStatus();
	
	public DashBoardResponse getDashBoardData(Integer userId);
	
	public String upsertEnquiry(EnquiryForm form);
	
	public List<EnquiryForm> getEnquries(Integer userId,EnquirySearchCriteria criteria);
	
	public EnquiryForm getEnquiry(Integer enqId);
}
