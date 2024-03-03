//package in.bhusanproj.expensetrackerapi.security;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import in.bhusanproj.expensetrackerapi.entity.User;
//import in.bhusanproj.expensetrackerapi.repository.UserRepository;
//
//@Service
//public class CustomUserDetailsService extends UserDetailsServiceAutoConfiguration {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	public UserDetails loadUserByUserName(String email) throws UsernameNotFoundException
//	{
//		User exuser=userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("usere not found by email"));
//
//		return new org.springframework.security.core.userdetails.User(exuser.getEmail(), exuser.getPassword(), new ArrayList<>());
//	}
//
//}
