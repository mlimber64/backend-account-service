package com.nttdata.bootcamp.backend.account.service;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.backend.account.model.accountType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface accountTypeService {
	
	Flux<accountType> findAll();
	
	Mono<accountType> findAllById(String id);
	
	Mono<accountType> save(accountType a);
	
	Mono<accountType> update(String id, accountType a);
	
	Mono<accountType> delete(String id);

}
