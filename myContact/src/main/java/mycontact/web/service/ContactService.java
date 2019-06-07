package mycontact.web.service;

import mycontact.web.entity.Contact;

import java.util.List;

public interface ContactService {
	Iterable<Contact> findAll();

    List<Contact> search(String term);

    Contact findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);
    
    List<Contact> searchByName(String name);
    List<Contact> searchByEmail(String email);
    List<Contact> searchByAddress(String address);
}
