package mycontact.web.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mycontact.web.entity.Role;
import mycontact.web.entity.User;
import mycontact.web.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);	//note that username parameter is mail of user
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		//get all roles of this user--------
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<Role> roles = user.getRoles();	//roles of this user
		
		for(Role role : roles ) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		//-----------------------------------
		
		return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), grantedAuthorities);//is an implement of UserDetails
	}

}
