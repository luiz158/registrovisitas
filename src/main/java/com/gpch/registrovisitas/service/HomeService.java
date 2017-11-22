package com.gpch.registrovisitas.service;

import java.util.Collection;

import com.gpch.registrovisitas.model.Home;

public interface HomeService {
	public Collection<Home> findAll();
	public Collection<Home> findByStreet(String street);
}
