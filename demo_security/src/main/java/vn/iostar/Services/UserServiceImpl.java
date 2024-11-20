package vn.iostar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.iostar.Repository.UserRepository;
import vn.iostar.entity.Users;

public class UserServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Users user = userRepository.getUserByUsername(username);

	    if (user == null) {
	        throw new UsernameNotFoundException("Could not find user");
	    }

	    return new MyUserService(user);
	}
}
