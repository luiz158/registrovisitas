package com.gpch.registrovisitas.repository;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gpch.registrovisitas.model.Home;

@DataJpaTest
@RunWith(SpringRunner.class)
public class HomeRepositoryTest {
	
	@Autowired
	private HomeRepository homeRepository;
	
	@Test
	public void test_SaveHome() {
		Home home = new Home(1L, "Main Avenue", 123, "John", "Smith", "john.smith@test.com", null, null);
		Home result = homeRepository.save(home);
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.getHomeId()).isEqualTo(1L);
		Assertions.assertThat(result.getStreet()).isEqualTo("Main Avenue");
		Assertions.assertThat(result.getNumber()).isEqualTo(123);
		Assertions.assertThat(result.getOwnerName()).isEqualTo("John");
		Assertions.assertThat(result.getOwnerLastName()).isEqualTo("Smith");
		Assertions.assertThat(result.getOwnerEmail()).isEqualTo("john.smith@test.com");
	}
	
	@Test
	public void test_FindAllHomes() {
		List<Home> homes = homeRepository.findAll();
		assertEquals(0, homes.size());
	}
	
	@Test
	public void test_HomeNoFound() {
		Home home = homeRepository.findOne(-1L);
		Assertions.assertThat(home).isNull();
	}
	
	@Test
	public void test_FindByHomeStreet() {
		Home home = new Home(1L, "Main Avenue", 123, "John", "Smith", "john.smith@test.com", null, null);
		homeRepository.save(home);
		Collection<Home> result = homeRepository.findByStreet("Main Avenue");
		Assertions.assertThat(result.size()).isEqualTo(1);
		Assertions.assertThat(result.iterator().next().getHomeId()).isGreaterThan(0);
		Assertions.assertThat(result.iterator().next().getStreet()).isEqualTo("Main Avenue");
	}
	

}
