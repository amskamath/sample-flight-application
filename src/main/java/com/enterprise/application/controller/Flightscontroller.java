package com.enterprise.application.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.application.model.Flight;
import com.enterprise.application.repository.Flightsrepository;
import com.enterprise.application.service.FlightService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Flightscontroller {
	
	@Autowired Flightsrepository flightRespository;
	@Autowired FlightService flightService;
	
	@GetMapping
	public String testdefaultHttpResponse() {
		return "Hello, World";
		
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<HttpStatus> addflights(@RequestBody Flight flight) {
		try {
			if(flight != null) {
				flightRespository.save(new Flight(flight.getFlightNumber(),flight.getDeparturePort(),
						flight.getArrivalPort(),flight.getDepartureTime(),flight.getArrivalTime()));
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/flightsbydate")
	public  ResponseEntity<List<Flight>> getflightsbyDateAndOrCode(@RequestParam (required = true) 
																   @DateTimeFormat(pattern = "yyyy-MM-dd")
																   Date departuredate,
														@RequestParam ( required = false) String code){
		try {
			 
			
			List<Flight> flightResult = flightService.findFlightsbydate(departuredate);
			if(code != null && flightResult !=null) {
				
				flightResult = flightResult.stream().filter(f -> f.getFlightNumber().contains(code)).collect(Collectors.toList());
			}
			if(flightResult != null)
				return new ResponseEntity<>(flightResult,HttpStatus.OK);
			else 
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/allflights")
	public  ResponseEntity<List<Flight>> getallflights(){
		try {
			
			List<Flight> flight = new ArrayList<Flight>();
			flight = flightRespository.findAll();
			
			if(flight == null)
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(flight,HttpStatus.OK);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	

}
