package com.oreilly.sdata;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
//@SuppressWarnings("unchecked")
public interface BaseRepository<T,ID extends Serializable>
	extends JpaRepository<T, ID> {
	
	public List<T>findByIds(ID... ids);
	//public String getStr();

}
