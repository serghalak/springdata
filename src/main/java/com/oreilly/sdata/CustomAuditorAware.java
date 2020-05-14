package com.oreilly.sdata;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		String name="Serg Khalak";
		return Optional.of(name);
	}
	

}
