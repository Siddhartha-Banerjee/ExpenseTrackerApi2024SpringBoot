package in.bhusanproj.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bhusanproj.expensetrackerapi.entity.Expense;
import in.bhusanproj.expensetrackerapi.entity.User;
import in.bhusanproj.expensetrackerapi.entity.UserModel;
import in.bhusanproj.expensetrackerapi.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> readUser(@PathVariable Long id)
	{
		return new ResponseEntity<User>(userService.readUser(id), HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public List<User> readUsers()
	{
		return userService.getAllUsers();
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody UserModel user, @PathVariable Long id)
	{
		return new ResponseEntity<User>(userService.updateUser(user,id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deluser/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id)
	{
		userService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	

}
