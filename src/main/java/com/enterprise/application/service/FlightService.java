package com.enterprise.application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.application.model.Flight;
import com.enterprise.application.repository.Flightsrepository;


/**
 * @author pairc
 *
 */
@Service
public class FlightService {
		
	@Autowired Flightsrepository flightRepository;
	
	public List<Flight> findFlightsbydate(Date dt){
		List<Flight> samedateFlights = new ArrayList<Flight>();
		try {
			//get List of departuredates from db
			List<Flight> flights = flightRepository.findAll();
			
			if(flights != null) {
				for(Flight fl : flights) {
					//get epoch milli and create date
					long epochMilli = fl.getDepartureTime().toInstant().toEpochMilli();
					Date date = new Date(epochMilli);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					if(sdf.format(date).equals(sdf.format(dt)) ){
						samedateFlights.add(fl);
					}
				}
			}
			
		}catch(Exception e) {
			System.out.println("Caught Exception"+e.getMessage());
		}
		
		return samedateFlights;
		
	}
	
}
