package mycontact.web.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import mycontact.web.entity.Role;
import mycontact.web.entity.User;
import mycontact.web.repository.RoleRepository;
import mycontact.web.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent>{

	 	@Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RoleRepository roleRepository;

	    @Autowired 
	    private PasswordEncoder passwordEncoder;

	    //onApplicationEvent() invoked when application start or refresh
	    @Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
	// Roles
	//check db have role admin, member. If not, create ROLE_ADMIN, ROLE_MEMBER then add to db
    if (roleRepository.findByName("ROLE_ADMIN") == null) {
        roleRepository.save(new Role("ROLE_ADMIN"));
    }

    if (roleRepository.findByName("ROLE_MEMBER") == null) {
        roleRepository.save(new Role("ROLE_MEMBER"));
    }

    //if not yet have user with ROLE_ADMIN create then save to db
    // Admin account
    if (userRepository.findByEmail("admin@gmail.com") == null) {
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword(passwordEncoder.encode("123456"));
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_ADMIN"));
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        admin.setRoles(roles);
        userRepository.save(admin);
    }

  //if not yet have user with ROLE_MEMBER create then save to db
    // Member account
    if (userRepository.findByEmail("member@gmail.com") == null) {
        User user = new User();
        user.setEmail("member@gmail.com");
        user.setPassword(passwordEncoder.encode("123456"));
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        userRepository.save(user);
    }
}

	
}

