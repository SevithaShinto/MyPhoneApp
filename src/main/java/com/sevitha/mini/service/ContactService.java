package com.sevitha.mini.service;

import java.util.List;

import com.sevitha.mini.entities.Contact;

public interface ContactService {
	
	//save contact
	boolean  saveContact(Contact contact);
	//get all
	List<Contact> getAllContact();
	//get by Id
	Contact    getContactById(Integer contactId);
	//delete by Id
	public boolean deleteContactById(Integer cid);
	//update contact
	public boolean updateContact(Contact contact);
	
	
}
