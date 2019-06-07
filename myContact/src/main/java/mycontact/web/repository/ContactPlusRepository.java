package mycontact.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mycontact.web.entity.Contact;

@Repository
public interface ContactPlusRepository extends JpaRepository<Contact, Integer> {

	// find name mail, address (string)
	String query = "select c from Contact c where "
			+ "(lower(c.name) like lower('%' || :name || '%') OR :name is null)  "
			+ "AND (lower(c.email) like lower('%' || :email || '%') OR :email is null)  "
			+ "AND (lower(c.address.addressName) like lower('%' || :addressname || '%') OR :addressname is null)  ";

	@Query(query)
	List<Contact> findByName(@Param("name") String name);

	List<Contact> findByEmail(@Param("email") String email);

	List<Contact> findByAddress(@Param("addressname") String address);

	///
}
