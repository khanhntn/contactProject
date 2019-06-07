package mycontact.web.repository;

import mycontact.web.entity.Contact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{
	List<Contact> findByNameContaining(String term);
	//as same as SELECT * FROM contact WHERE name LIKE %term%.
	
	//have other method extend by CrudRepository:
	//count()
	//delete(entity) / deleteAll/ deleteById
	//existsById
	//findAll()		/findById()
	//save(S entity)	//saveAll(Interable )
}
