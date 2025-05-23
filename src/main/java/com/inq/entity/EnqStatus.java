package com.inq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ALT Enquiry Status")
@Data
public class EnqStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer statusId;
	
	private Integer statusName;
}
