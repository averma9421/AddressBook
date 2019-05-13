package org.app.addressbook.web;

import java.util.List;

import org.app.addressbook.domain.Contact;
import org.app.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ContactRestController {
	@Autowired
	private ContactRepository addressRepository;

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public List<Contact> address() {
		return addressRepository.findAll();
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contact> addressById(@PathVariable Long id) {
		Contact contact = addressRepository.findOne(id);
		if (contact == null) {
			return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Contact> deleteAddress(@PathVariable Long id) {
		Contact contact = addressRepository.findOne(id);
		if (contact == null) {
			return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
		} else {
			addressRepository.delete(contact);
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public ResponseEntity<Contact> createAddress(@RequestBody Contact contact) {
		return new ResponseEntity<Contact>(addressRepository.save(contact), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/address", method = RequestMethod.PUT)
	public Contact updateAddress(@RequestBody Contact contact) {
		return addressRepository.save(contact);
	}

}
