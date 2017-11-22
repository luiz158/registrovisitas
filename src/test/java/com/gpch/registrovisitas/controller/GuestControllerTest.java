package com.gpch.registrovisitas.controller;

import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.gpch.registrovisitas.model.Guest;
import com.gpch.registrovisitas.service.GuestService;

@WebMvcTest(GuestController.class)
@RunWith(SpringRunner.class)
public class GuestControllerTest {

	@MockBean
	private GuestService guestService;

	@Autowired
	private MockMvc mockMvc;

	private Guest guest;

	@Before
	public void init() {
		LocalDateTime arrivalTime = LocalDateTime.now();
		guest = new Guest(1L, "Gustavo", "Ponce", "AEG-62-54", "IFE 12345", "DHL", arrivalTime,
				arrivalTime.plusHours(2));
	}

	@Test
	@WithMockUser(username="admin", password="admin", roles={"USER"})
	public void test_getAllGuests() throws Exception {
		Mockito.when(guestService.findAll()).thenReturn(Collections.singletonList(guest));
		mockMvc.perform(MockMvcRequestBuilders.get("/guests"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(MockMvcResultMatchers.jsonPath("@.[0].guestId").value(1L))
			.andExpect(MockMvcResultMatchers.jsonPath("@.[0].name").value("Gustavo"));
	}
}
