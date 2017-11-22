package com.gpch.registrovisitas.service;

import java.util.Collection;

import com.gpch.registrovisitas.model.Guest;

public interface GuestService {
	public Collection<Guest> findAll();
	public Collection<Guest> findByName(String name);

}
