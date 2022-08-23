package com.sevitha.mini.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevitha.mini.entities.Contact;
import com.sevitha.mini.repository.ContactRepo;
import com.sevitha.mini.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;
	
	//save contact
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		
		if(save != null)
		{
			return true;
		}
		else {
			return false;
		}
	}

	//get all
	
	@Override
	public List<Contact> getAllContact() {
		List<Contact> findAll = contactRepo.findAll();
		return findAll;
	}

	//get by Id
	
	@Override
	public Contact getContactById(Integer cId) {
		Contact findById = contactRepo.findById(cId).get();
		return findById;
	}
	
	//update all
	@Override
	public boolean updateContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		
		if(save != null)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//delete by Id

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
