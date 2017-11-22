package com.gpch.registrovisitas.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.gpch.registrovisitas.model.Guest;
import com.gpch.registrovisitas.repository.GuestRepository;

@Service("guestService")
public class GuestServiceImpl implements GuestService{
	
	private GuestRepository guestRepository;
	
	public GuestServiceImpl(GuestRepository guestRepository) {
		super();
		this.guestRepository = guestRepository;
	}

	@Override
	public Collection<Guest> findAll() {
		return guestRepository.findAll();
	}



	@Override
	public Collection<Guest> findByName(String name) {
		return guestRepository.findByName(name);
	}

}
