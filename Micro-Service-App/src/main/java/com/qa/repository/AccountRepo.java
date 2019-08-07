package com.qa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.AccountEntity;


	@Repository
	public interface AccountRepo extends JpaRepository<AccountEntity, Long>{

		
	}

	
	

