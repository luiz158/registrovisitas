package com.gpch.registrovisitas.service;

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

import com.gpch.registrovisitas.model.Home;
import com.gpch.registrovisitas.repository.HomeRepository;

@RunWith(SpringRunner.class)
public class HomeServiceTest {
	@MockBean
	private HomeRepository homeRepository;

	@Autowired
	private HomeService homeService;
	
	private Home home;
	
	@Before
	public void init() {
		home = new Home(1L, "Main Avenue", 123, "John", "Smith", "john.smith@test.com", null, null);
	}
	
	@Test
	public void test_findAllHomes() {
		Mockito.when(homeRepository.findAll()).thenReturn(Collections.singletonList(home));
		Collection<Home> homes = homeService.findAll();
		Assertions.assertThat(homes.size()).isEqualTo(1);
	}
	
	@Test
	public void test_FindByStreet() {
		Mockito.when(homeRepository.findByStreet("Main Avenue")).thenReturn(Collections.singletonList(home));
		Collection<Home> homes = homeService.findByStreet("Main Avenue");
		Assertions.assertThat(homes.size()).isEqualTo(1);
		Assertions.assertThat(homes.iterator().next().getStreet()).isEqualTo("Main Avenue");

	}
	
	@Configuration
	static class HomeServiceTestContextConfiguration {

		@Bean
		public HomeService homeService() {
			return new HomeServiceImpl(homeRepository());
		}

		@Bean
		public HomeRepository homeRepository() {
			return Mockito.mock(HomeRepository.class);
		}
	}
	
}
