package com.gpch.registrovisitas.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.gpch.registrovisitas.model.Guest;
import com.gpch.registrovisitas.repository.GuestRepository;

@RunWith(SpringRunner.class)
public class GuestServiceTest {

	@MockBean
	private GuestRepository guestRepository;

	@Autowired
	private GuestService guestService;
	
	private Guest guest;
	
	@Before
	public void init() {
		LocalDateTime arrivalTime = LocalDateTime.now();
		guest = new Guest(1L, "Gustavo", "Ponce", "AEG-62-54", "IFE 12345", "DHL", arrivalTime,
				arrivalTime.plusHours(2));
	}
	

	@Test
	public void test_findAllGuests() {
		Mockito.when(guestRepository.findAll()).thenReturn(Collections.singletonList(guest));
		Collection<Guest> guests = guestService.findAll();
		Assertions.assertThat(guests.size()).isEqualTo(1);
	}
	
	@Test
	public void test_FindByName() {
		Mockito.when(guestRepository.findByName("Gustavo")).thenReturn(Collections.singletonList(guest));
		Collection<Guest> guests = guestService.findByName("Gustavo");
		Assertions.assertThat(guests.size()).isEqualTo(1);
		Assertions.assertThat(guests.iterator().next().getName()).isEqualTo("Gustavo");

	}

	@Configuration
	static class GuestServiceTestContextConfiguration {

		@Bean
		public GuestService guestService() {
			return new GuestServiceImpl(guestRepository());
		}

		@Bean
		public GuestRepository guestRepository() {
			return Mockito.mock(GuestRepository.class);
		}
	}

}
