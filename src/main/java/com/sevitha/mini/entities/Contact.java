package com.sevitha.mini.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	String contactName;
	
	@Column(name = "CONTACT_NUMBER")
	String contactNumber;
	
	@Column(name = "CONTACT_EMAIL")
	String contactEmail;
	
	@Column(name = "ACTIVE_SWITCH")
	Character activeSwitch;
	
	@Column(name = "CREATED_DATE")
	LocalDate createdDate;
	
	@Column(name = "UPDATED_DATE")
	LocalDate  updateDate;
}
