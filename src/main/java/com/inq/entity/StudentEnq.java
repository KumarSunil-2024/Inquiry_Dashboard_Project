package com.inq.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "STUDENT_ENQ")
public class StudentEnq {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enquiryId;
	
	private String studentName;
	
	private Integer phNo;
	
	private String classMode;
	
	private String enqStatus;
	
	private LocalDate createdDate;
	
    private LocalDate updatedDate;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserDtls user;
	
}
