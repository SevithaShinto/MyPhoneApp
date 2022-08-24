package com.sevitha.mini.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		List<Contact> contacts = contactRepo.findAll();
		Stream<Contact> stream = contacts.stream();
		Stream<Contact> filter = stream.filter(contact-> contact.getActiveSwitch()== 'Y');
		List<Contact> collect = filter.collect(Collectors.toList());
		return collect;
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
	public boolean deleteContactById(Integer cid) {
//		boolean existsById = contactRepo.existsById(cid);
//		if(existsById)
//		{
//			contactRepo.deleteById(cid);
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		
//		Optional<Contact> contact = contactRepo.findById(cid);
//		if(contact.isPresent())
//		{
//			contactRepo.deleteById(cid);
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		
		Optional<Contact> contact = contactRepo.findById(cid);
		if(contact.isPresent())
		{
			Contact contact2 = contact.get();
			contact2.setActiveSwitch('N');
			contactRepo.save(contact2);
			return true;
		}
		else
			return false;
		
	}

}
