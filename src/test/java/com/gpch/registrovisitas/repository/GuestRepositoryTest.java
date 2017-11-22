package com.gpch.registrovisitas.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gpch.registrovisitas.model.Guest;

@DataJpaTest
@RunWith(SpringRunner.class)
public class GuestRepositoryTest {
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Test
	public void test_SaveGuest() {
		LocalDateTime arrivalTime = LocalDateTime.now();
		Guest guest = new Guest(1L, "Gustavo", "Ponce", "AEG-62-54", "IFE 12345", "DHL", arrivalTime,
				arrivalTime.plusHours(2));
		Guest result = guestRepository.save(guest);
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.getGuestId()).isEqualTo(1L);
		Assertions.assertThat(result.getName()).isEqualTo("Gustavo");
		Assertions.assertThat(result.getLastName()).isEqualTo("Ponce");
		Assertions.assertThat(result.getCarPlateNumber()).isEqualTo("AEG-62-54");
		Assertions.assertThat(result.getIdentificationPresented()).isEqualTo("IFE 12345");
		Assertions.assertThat(result.getReasonOfVisit()).isEqualTo("DHL");
		Assertions.assertThat(result.getDepartTime().minusHours(2)).isEqualTo(result.getArriveTime());
	}
	
	@Test
	public void test_FindAllGuests() {
		List<Guest> guests = guestRepository.findAll();
		assertEquals(0, guests.size());
	}
	
	@Test
	public void test_GuestNoFound() {
		Guest guest = guestRepository.findOne(-1L);
		Assertions.assertThat(guest).isNull();
	}
	
	@Test
	public void test_FindByGuestName() {
		LocalDateTime arrivalTime = LocalDateTime.now();
		Guest guest = new Guest(1L, "Gustavo", "Ponce", "AEG-62-54", "IFE 12345", "DHL", arrivalTime,
				arrivalTime.plusHours(2));
		guestRepository.save(guest);
		Collection<Guest> result = guestRepository.findByName("Gustavo");
		Assertions.assertThat(result.size()).isEqualTo(1);
		Assertions.assertThat(result.iterator().next().getGuestId()).isGreaterThan(0);
		Assertions.assertThat(result.iterator().next().getName()).isEqualTo("Gustavo");
	}

}
