package com.nttdata.bootcamp.backend.account.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.bootcamp.backend.account.model.accountType;
import com.nttdata.bootcamp.backend.account.repository.accountTypeRepository;
import com.nttdata.bootcamp.backend.account.service.accountTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class accountTypeServiceImpl implements accountTypeService {
	
	@Autowired
	private accountTypeRepository repositoryType;

	@Override
	public Flux<accountType> findAll() {
		return repositoryType.findAll();
	}

	@Override
	public Mono<accountType> findAllById(String id) {
		return repositoryType.findById(id);
	}

	@Override
	public Mono<accountType> save(accountType a) {
		return repositoryType.save(a);
	}

	@Override
	public Mono<accountType> update(String id, accountType a) {
		return repositoryType.findById(id)
				.flatMap(ac -> {
					a.setId(id);
					return save(a);
				})
				.switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<accountType> delete(String id) {
		return  repositoryType
				.findById(id)
				.flatMap(a -> repositoryType.deleteById(a.getId()).thenReturn(a));
	}

}
