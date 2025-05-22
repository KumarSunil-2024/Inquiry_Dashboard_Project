package com.inq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ALT Enquiry Status")
@Data
public class EnqStatus {

	@Id
	private Integer statusId;
	
	private Integer statusName;
}
