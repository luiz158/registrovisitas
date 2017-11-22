package com.gpch.registrovisitas.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpch.registrovisitas.model.Home;
import com.gpch.registrovisitas.service.HomeService;

@RestController
public class HomeController {

	private HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		super();
		this.homeService = homeService;
	}

	@GetMapping(value = "/homes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Collection<Home> homes() {
		return homeService.findAll();
	}

}
