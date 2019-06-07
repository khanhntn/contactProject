package mycontact.web.repository;

import org.springframework.data.repository.CrudRepository;
import mycontact.web.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findByName(String name);
}
