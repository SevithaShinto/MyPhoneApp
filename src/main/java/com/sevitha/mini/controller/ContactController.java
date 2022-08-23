package com.sevitha.mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sevitha.mini.entities.Contact;
import com.sevitha.mini.serviceImpl.ContactServiceImpl;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
	//save contact
	@PostMapping(value = "/saveContact" , consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact)
	{
		boolean saveContact = contactServiceImpl.saveContact(contact);
		
		if(saveContact == true)
		{
			String msg="Contact Saved Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else
		{
			String msg="Contact Not Saved";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//get all
	@GetMapping(value = "/getAllContact" , produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContacts()
	{
		List<Contact> allContact = contactServiceImpl.getAllContact();
		
		if(allContact != null )
		{
			return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
		}
		else
		{
			String msg="Data not found";
			return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	//get by Id
	@GetMapping(value = "/getContactById/{cId}", produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer cId)
	{
		Contact contactById = contactServiceImpl.getContactById(cId);
		
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
		
	}
}
