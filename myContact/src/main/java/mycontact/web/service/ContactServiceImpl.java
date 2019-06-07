package mycontact.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mycontact.web.entity.Contact;
import mycontact.web.repository.ContactPlusRepository;
import mycontact.web.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	 @Autowired
	 private ContactRepository contactRepository;
	 
	 @Autowired
	 private ContactPlusRepository contactPlusRepository;
	 
	@Override
	public Iterable<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> search(String term) {
		return contactRepository.findByNameContaining(term);
	}

	@Override
	public Contact findOne(Integer id) {
		return  contactRepository.findById(id).get();
	}

	@Override
	public void save(Contact contact) {
		contactRepository.save(contact);
		
	}

	@Override
	public void delete(Integer id) {
		contactRepository.deleteById(id);
		
	}

	//============================================
	@Override
	public List<Contact> searchByName(String name) {
		return contactPlusRepository.findByName(name);
	}

	@Override
	public List<Contact> searchByEmail(String email) {		
		return contactPlusRepository.findByEmail(email);
	}

	@Override
	public List<Contact> searchByAddress(String address) {
		return contactPlusRepository.findByAddress(address);
	}

}
