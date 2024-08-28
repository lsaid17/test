package com.test.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.models.LogInformation;
import com.test.api.repository.LogInformationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LogInformationDao {
	
	@Autowired
	private LogInformationRepository logInformationRepository;
	
	public void save(LogInformation entity) {
		this.logInformationRepository.save(entity);
	}

}
