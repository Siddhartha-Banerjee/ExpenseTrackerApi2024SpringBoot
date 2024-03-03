package in.bhusanproj.expensetrackerapi.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import in.bhusanproj.expensetrackerapi.security.CustomUserDetailsService;

@Configuration
public class WebSecurityConfig {
	
//	@Autowired
//	private CustomUserDetailsService cuserDetailsService;
	
//	@Bean
//	public JwtRequestFilter authenticationJwtTokenFilter()
//	{
//		return new JwtRequestFilter();
//	}
	
	
	
	
	
	
	
	
	 @Bean
	 public WebSecurityCustomizer webSecurityCustomizer() {
		 
	      return (web) -> web.ignoring().requestMatchers("/login", "/register","/expense","/delexpenses");
	    
	 }
	 
//	 @Bean
//	 public UserDetails userDetailsService(String email) {
//	        
//		 return cuserDetailsService.loadUserByUserName(email);
//	 }
	 //not able to use db username and pw
	 
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user1 = User.withDefaultPasswordEncoder()
	            .username("user")
	            .password("password")
	            .roles("USER")
	            .build();
	        
	        return new InMemoryUserDetailsManager(user1);
	    }
	 //for single user
	 
	 
//	 @Bean
//	 public InMemoryUserDetailsManager userDetailsService() {
//		 
//		 InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
//		 
//	        UserDetails user1 = User.withDefaultPasswordEncoder()
//	            .username("user")
//	            .password("password")
//	            .roles("USER")
//	            .build();
//	        
//	        UserDetails user2 = User.withDefaultPasswordEncoder()
//		            .username("user2")
//		            .password("password2")
//		            .roles("USER")
//		            .build();
//	        
//	        userDetailsManager.createUser(user2);
//	        userDetailsManager.createUser(user1);
//	        
//	        return userDetailsManager;
//	        
//	    }
	 //for multiple user
	 
	
	 
	 
//	    public void config(AuthenticationManagerBuilder auth) throws Exception {
//		 
//		 InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
//	        UserDetails user1 = User.withDefaultPasswordEncoder()
//	            .username("user")
//	            .password("password")
//	            .roles("USER")
//	            .build();
//	        
//	        UserDetails user2 = User.withDefaultPasswordEncoder()
//		            .username("user2")
//		            .password("password2")
//		            .roles("USER")
//		            .build();
//	        userDetailsManager.createUser(user2);
//	        userDetailsManager.createUser(user1);
//	        
//	        auth.userDetailsService(userDetailsManager);
//	        
//	    }
//	 
	 
//	 protected void config(AuthenticationManagerBuilder auth) throws Exception
//	 {
//		 auth.userDetailsService(cuserDetailsService);
//	 }
	 //depricated
	 
//	 @Bean
//	 public PasswordEncoder passwordEncoder()
//	 {
//		 return new BCryptPasswordEncoder();
//	 }
	 //not able to use passwordencoder because of depricated methods
	 
//	 @Bean
//	 @Override
//	 public AuthenticationManager authenticationManagerBean() throws Exception
//	 {
//		 return super.authenticationmanagerBean();
//	 }
	 //depricated
	 
	 
	 
	 

}
