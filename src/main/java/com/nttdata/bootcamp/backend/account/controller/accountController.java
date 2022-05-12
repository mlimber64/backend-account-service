package com.nttdata.bootcamp.backend.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nttdata.bootcamp.backend.account.model.account;
import com.nttdata.bootcamp.backend.account.service.accountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/account")
public class accountController {
	
	@Autowired
	private accountService serviceAccount;
	
	@GetMapping
	private Flux<account> findAll(){
		return serviceAccount.findAll();
	}
	
	@GetMapping("/account/{id}")
	private Mono<account> findById(@PathVariable("id") String id){
		return serviceAccount.findAllById(id);
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Mono<account> save(@RequestBody account a){
		return serviceAccount.save(a);
	}
	
	@PutMapping("/account/{id}")
	private Mono<ResponseEntity<account>> update(@PathVariable("id") String id, @RequestBody account a){
		return serviceAccount.update(id, a)
				.flatMap(acounts -> Mono.just(ResponseEntity.ok(acounts)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}
	
	@DeleteMapping("/account/{id}")
	private Mono<ResponseEntity<account>> delete(@PathVariable("id") String id){
		return serviceAccount.delete(id)
				.flatMap(acount -> Mono.just(ResponseEntity.ok(acount)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

}
