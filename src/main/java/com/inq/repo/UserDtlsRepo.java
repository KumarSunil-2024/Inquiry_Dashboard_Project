package com.inq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inq.entity.UserDtls;

public interface UserDtlsRepo extends JpaRepository<UserDtls,Integer>{

	public UserDtls findByEmail(String email);
}
