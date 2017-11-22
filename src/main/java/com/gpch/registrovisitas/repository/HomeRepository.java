package com.gpch.registrovisitas.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gpch.registrovisitas.model.Home;

@Repository("homeRepository")
public interface HomeRepository extends JpaRepository<Home, Long>{
	Collection<Home> findByStreet(String street);
}
