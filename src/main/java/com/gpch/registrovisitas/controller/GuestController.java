package com.gpch.registrovisitas.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpch.registrovisitas.model.Guest;
import com.gpch.registrovisitas.service.GuestService;

@RestController
public class GuestController {

	private GuestService guestService;

	@Autowired
	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}

	@GetMapping(value = "/guests", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Collection<Guest> guests() {
		return guestService.findAll();
	}

}
