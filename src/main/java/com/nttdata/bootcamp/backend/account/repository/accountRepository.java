package com.nttdata.bootcamp.backend.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.backend.account.model.account;

@Repository
public interface accountRepository extends ReactiveMongoRepository<account, String> {

}
