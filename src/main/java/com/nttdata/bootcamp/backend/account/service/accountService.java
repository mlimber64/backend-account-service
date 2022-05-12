package com.nttdata.bootcamp.backend.account.service;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.backend.account.model.account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface accountService {
	
	Flux<account> findAll();
	
	Mono<account> findAllById(String id);
	
	Mono<account> save(account a);
	
	Mono<account> update(String id ,account a);
	
	Mono<account> delete(String id);

}
