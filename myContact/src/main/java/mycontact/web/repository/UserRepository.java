package mycontact.web.repository;

import org.springframework.data.repository.CrudRepository;

import mycontact.web.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
