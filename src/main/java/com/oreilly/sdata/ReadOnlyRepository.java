package com.oreilly.sdata;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<T,ID extends Serializable> extends Repository<T,ID> {
	
	T findOne(ID id);
	Iterable<T>findAll();
	//<S extends T> S save(S obj);
}
