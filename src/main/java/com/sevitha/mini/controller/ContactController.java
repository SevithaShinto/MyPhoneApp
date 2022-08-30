package com.sevitha.mini.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sevitha.mini.entities.Contact;
import com.sevitha.mini.service.ContactServiceI;
import com.sevitha.mini.util.AppConstants;
import com.sevitha.mini.util.AppProps;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactService;
	
	@Autowired
	private AppProps appProps;
	
//	Map<String, String> messages = appProps.getMessages();
	
	//save contact
	@PostMapping(value = "/saveContact" , consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact)
	{
		boolean saveContact = contactService.saveContact(contact);
		
		Map<String, String> messages = appProps.getMessages();
		
		if(saveContact == true)
		{
//			String msg="Contact Saved Successfully";
//			String msg=messages.get("saveSuccess");
			String msg=messages.get(AppConstants.SAVE_SUCCESS);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else
		{
//			String msg="Contact Not Saved";
//			String msg=messages.get("saveFail");
			String msg=messages.get(AppConstants.SAVE_FAIL);
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//get all
	@GetMapping(value = "/getAllContact" , produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContacts()
	{
		List<Contact> allContact = contactService.getAllContact();
		
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
		Contact contactById = contactService.getContactById(cId);
		
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
		
	}
	
	//update
	@PutMapping(value = "/updateContact" , consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact)
	{
		boolean updateContact = contactService.updateContact(contact);
		
		Map<String, String> messages = appProps.getMessages();
		
		if(updateContact == true)
		{
//			String msg="Contact Saved Successfully";
//			String msg=messages.get("updateSuccess");
			String msg=messages.get(AppConstants.UPDATE_SUCCESS);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else
		{
//			String msg="Contact Not Saved";
			String msg=messages.get(AppConstants.UPDATE_FAIL);
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//delete contact by ID
	@DeleteMapping(value = "/deleteContactById/{cid}" )
	public ResponseEntity<String> deleteContactById(@PathVariable Integer cid){
		boolean deleteContactById = contactService.deleteContactById(cid);
		
		Map<String, String> messages = appProps.getMessages();
		
		if(deleteContactById)
		{
//			return new ResponseEntity<String>("Record Deleted Successfully!!",HttpStatus.OK);
			
			return new ResponseEntity<String>(messages.get(AppConstants.DELETE_SUCCESS),HttpStatus.OK);
		}
		else
		{
		//	return new ResponseEntity<String>("Record not Found!!",HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity<String>(messages.get(AppConstants.DELETE_FAIL),HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
