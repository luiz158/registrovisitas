package com.gpch.registrovisitas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guest")
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Guest {
	
	@Id
	@GeneratedValue
	@Column(name = "guest_id")
	private long guestId;
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "car_plate_number")
	private String carPlateNumber;
	@Column(name = "identification_presented")
	private String identificationPresented;
	@Column(name = "reason_of_visit")
	private String reasonOfVisit;
	@Column(name = "arrive_time")
	private LocalDateTime arriveTime;
	@Column(name = "depart_time")
	private LocalDateTime departTime;
	
}
