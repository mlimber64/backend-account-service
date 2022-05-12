package com.nttdata.bootcamp.backend.account.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.bootcamp.backend.account.model.account;
import com.nttdata.bootcamp.backend.account.repository.accountRepository;
import com.nttdata.bootcamp.backend.account.service.accountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class accountServiceImpl implements accountService{
	
	@Autowired
	private accountRepository repositoryAccount;

	@Override
	public Flux<account> findAll() {
		return repositoryAccount.findAll();
	}

	@Override
	public Mono<account> findAllById(String id) {
		return repositoryAccount.findById(id);
	}

	@Override
	public Mono<account> save(account a) {
		return repositoryAccount.save(a);
	}

	@Override
	public Mono<account> update(String id, account a) {
		return repositoryAccount.findById(id)
				.flatMap(ac -> {
					ac.setId(id);
					return save(a);
				})
				.switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<account> delete(String id) {
		return repositoryAccount
				.findById(id)
				.flatMap(a -> repositoryAccount.deleteById(a.getId()).thenReturn(a));
	}

}
