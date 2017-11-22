package com.gpch.registrovisitas.model;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.util.Assert;

public class GuestTest {

	@Test
	public void creationWithNoArgumentsConstructor() {
		Guest guest = new Guest();
		Assert.notNull(guest);
	}

	@Test
	public void creationWithArgumentsConstructor() {
		LocalDateTime arrivalTime = LocalDateTime.now();
		Guest guest = new Guest(1L, "Gustavo", "Ponce", "AEG-62-54", "IFE 12345", "DHL", arrivalTime,
				arrivalTime.plusHours(2));
		Assertions.assertThat(guest).isNotNull();
		Assertions.assertThat(guest.getGuestId()).isEqualTo(1L);
		Assertions.assertThat(guest.getName()).isEqualTo("Gustavo");
		Assertions.assertThat(guest.getLastName()).isEqualTo("Ponce");
		Assertions.assertThat(guest.getCarPlateNumber()).isEqualTo("AEG-62-54");
		Assertions.assertThat(guest.getIdentificationPresented()).isEqualTo("IFE 12345");
		Assertions.assertThat(guest.getReasonOfVisit()).isEqualTo("DHL");
		Assertions.assertThat(guest.getDepartTime().minusHours(2)).isEqualTo(guest.getArriveTime());
	}

}
