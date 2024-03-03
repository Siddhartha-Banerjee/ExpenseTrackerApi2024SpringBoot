package in.bhusanproj.expensetrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import in.bhusanproj.expensetrackerapi.entity.AuthModel;
import in.bhusanproj.expensetrackerapi.entity.User;
import in.bhusanproj.expensetrackerapi.entity.UserModel;
import in.bhusanproj.expensetrackerapi.service.UserService;
import jakarta.validation.Valid;

@RestController
public class AuthController {
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
	
//	@Autowired
//	private CustomUserDetailsService userDetailsSevice;
//	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login()
	{
		
		return new ResponseEntity<String>("User is logged in",HttpStatus.OK);
		
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<JwtResponse> login(@RequestBody AuthModel authModel )
//	{
////		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(),authModel.getPassword()));
//		authenticate(authModel.getEmail(),authModel.getPassword());
//		final UserDetails userDetails= userDetailsService.loadUserByUsername(authModel.getEmail());
//		final String token=jwtTokenUtil.generateToken(userDetails);
//	
////		SecurityContextHolder.getContext().setAuthentication(authentication);
//		return new ResponseEntity<JwtResponse>(new jwtResponse(token),HttpStatus.OK);
//	}
	
	
//	private void authenticate(String email, String pasword)
//	{
//		try
//		{
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password);
//		}
//		catch(DisabledException e)
//		{
//			throw new Exception("user disabled");
//		}
//		catch(BadCredentialsException e)
//		{
//			throw new Exception("bad credentials");
//		}
//	}
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user)
	{
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

}
