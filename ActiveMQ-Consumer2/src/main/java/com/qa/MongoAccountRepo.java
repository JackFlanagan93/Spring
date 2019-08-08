package com.qa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.AccountEntity;

@Repository
public interface MongoAccountRepo extends MongoRepository<AccountEntity, String> {
}