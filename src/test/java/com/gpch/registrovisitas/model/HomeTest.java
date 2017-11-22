package com.gpch.registrovisitas.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.util.Assert;

public class HomeTest {
	@Test
	public void creationWithNoArgumentsConstructor() {
		Home home = new Home();
		Assert.notNull(home);
	}

	@Test
	public void creationWithArgumentsConstructor() {
		Home home = new Home(1L, "Main Avenue", 123, "John", "Smith", "john.smith@test.com", null, null);
		Assertions.assertThat(home).isNotNull();
		Assertions.assertThat(home.getHomeId()).isEqualTo(1L);
		Assertions.assertThat(home.getStreet()).isEqualTo("Main Avenue");
		Assertions.assertThat(home.getNumber()).isEqualTo(123);
		Assertions.assertThat(home.getOwnerName()).isEqualTo("John");
		Assertions.assertThat(home.getOwnerLastName()).isEqualTo("Smith");
		Assertions.assertThat(home.getOwnerEmail()).isEqualTo("john.smith@test.com");
	}

}
