package com.nttdata.bootcamp.backend.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.backend.account.model.accountType;

@Repository
public interface accountTypeRepository extends ReactiveMongoRepository<accountType, String> {

}
