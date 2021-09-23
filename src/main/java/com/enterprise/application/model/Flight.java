package com.enterprise.application.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.enterprise.application.utils.*;


@Entity
@Table(name = "Flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "flight_Number")
	private String flight_Number;
	
	@Column(name = "departure_Port")
	private String departurePort;
	
	@Column(name = "arrival_Port")
	private String arrivalPort;
	
	@JsonDeserialize(using = DateTimeDeserializer.class)
    @JsonSerialize(using = DateTimeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:MM:SSZ")
	@Column(name = "departure_Time")
	private	OffsetDateTime departureTime;  
	
	@JsonDeserialize(using = DateTimeDeserializer.class)
    @JsonSerialize(using = DateTimeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:MM:SSZ")
	@Column(name = "arrival_Time")
	private OffsetDateTime arrivalTime;  
	
	public Flight() {
		
	}
	

	public Flight(String flightNumber, String departurePort, String arrivalPort, OffsetDateTime departureTime,
			OffsetDateTime arrivalTime) {
		super();
		this.flight_Number = flightNumber;
		this.departurePort = departurePort;
		this.arrivalPort = arrivalPort;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flight_Number;
	}

	public void setFlightNumber(String flightNumber) {
		this.flight_Number = flightNumber;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	public String getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	public OffsetDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(OffsetDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public OffsetDateTime getArrivalTime() {
		return departureTime;
	}

	public void setArrivalTime(OffsetDateTime arrivalTime) {
		this.departureTime = arrivalTime;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Flight [flightNumber=" + flight_Number + ", departurePort=" + departureTime + ", arrivalPort="
				+ arrivalPort + ", departureTime=" + departureTime + ", arrivalTime=" + departureTime + "]";
	}
	
	
	

}
