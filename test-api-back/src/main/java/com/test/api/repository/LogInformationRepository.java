package com.test.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.api.models.LogInformation;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LogInformationRepository extends CrudRepository<LogInformation, Integer> {

}
