package com.enterprise.application.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.application.model.Flight;

public interface Flightsrepository extends JpaRepository<Flight, Long> {
	
	List<Flight> findByDepartureTime(OffsetDateTime departuretime);
		
	List<Flight> findAll();
	
	@SuppressWarnings("unchecked")
	Flight save(Flight f);

}
