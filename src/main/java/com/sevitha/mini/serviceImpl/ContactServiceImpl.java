package com.sevitha.mini.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sevitha.mini.entities.Contact;
import com.sevitha.mini.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	//save contact
	
	@Override
	public boolean saveContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	//get all
	
	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return null;
	}

	//get by Id
	
	@Override
	public Contact getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//delete by Id

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return false;
	}

}
