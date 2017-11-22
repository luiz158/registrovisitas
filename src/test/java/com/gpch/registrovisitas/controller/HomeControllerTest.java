package com.gpch.registrovisitas.controller;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.gpch.registrovisitas.model.Home;
import com.gpch.registrovisitas.service.HomeService;

@WebMvcTest(HomeController.class)
@RunWith(SpringRunner.class)
public class HomeControllerTest {

	@MockBean
	private HomeService homeService;

	@Autowired
	private MockMvc mockMvc;

	private Home home;

	@Before
	public void init() {
		home = new Home(1L, "Main Avenue", 123, "John", "Smith", "john.smith@test.com", null, null);

	}

	@Test
	public void test_getAllHomes() throws Exception {
		Mockito.when(homeService.findAll()).thenReturn(Collections.singletonList(home));
		mockMvc.perform(MockMvcRequestBuilders.get("/homes")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].homeId").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].street").value("Main Avenue"));
	}
}
