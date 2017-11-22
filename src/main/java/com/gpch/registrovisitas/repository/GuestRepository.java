package com.gpch.registrovisitas.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gpch.registrovisitas.model.Guest;

@Repository("guestRepository")
public interface GuestRepository extends JpaRepository<Guest, Long> {
	Collection<Guest> findByName(String guestName);
}
