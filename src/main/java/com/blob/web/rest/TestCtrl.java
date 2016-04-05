package com.blob.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class TestCtrl extends AbstractCtrl {
	
	/*@Resource
	private ContactDao contactDao;

	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contact getContact(@PathVariable Long id){
		System.out.println("  id ===>   "+id);
		Contact contact = contactDao.findOne(id);
		contact.setId(id);
		
		return contact;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Contact> getAllContacts(){
		
		traceAction("getAllContacts .. ");
		
		System.out.println("  getAllContacts ===>   ");
		List<Contact> contacts = contactDao.findAll();
		return contacts;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long createContact(Contact c){
		System.out.println("  create contact "+c.getFirstName());
		
		if(c != null && c.getFirstName() != null){
			c = contactDao.save(c);
		}
		return c.getId();
	}*/
	
	/*@RequestMapping(value="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> hello(){
		
		System.out.println("  hello ===>   ");
		
		Contact c = new Contact();
		c.setId(1L);
		c.setFirstName("Max");
		
		c = new Contact();
		c.setId(2L);
		c.setFirstName("Mark");
		
		return new ResponseEntity<Contact>(c, HttpStatus.OK);
	}*/
}
