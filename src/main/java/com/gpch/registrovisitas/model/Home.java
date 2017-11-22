package com.gpch.registrovisitas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "home")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {
	@Id
	@GeneratedValue
	@Column(name = "home_id")
	private long homeId;
	@Column(name = "street")
	private String street;
	@Column(name = "number")
	private int number;
	@Column(name = "owner_name")
	private String ownerName;
	@Column(name = "owner_last_name")
	private String ownerLastName;
	@Column(name = "owner_email")
	private String ownerEmail;
	@ElementCollection
	private List<String> contactPhoneNumbers;
	@ElementCollection
	private List<Guest> guests;
	
}
