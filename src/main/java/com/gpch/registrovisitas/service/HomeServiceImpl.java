package com.gpch.registrovisitas.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.gpch.registrovisitas.model.Home;
import com.gpch.registrovisitas.repository.HomeRepository;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

	private HomeRepository homeRepository;

	public HomeServiceImpl(HomeRepository homeRepository) {
		super();
		this.homeRepository = homeRepository;
	}

	@Override
	public Collection<Home> findAll() {
		return homeRepository.findAll();
	}

	@Override
	public Collection<Home> findByStreet(String street) {
		return homeRepository.findByStreet(street);
	}

}
