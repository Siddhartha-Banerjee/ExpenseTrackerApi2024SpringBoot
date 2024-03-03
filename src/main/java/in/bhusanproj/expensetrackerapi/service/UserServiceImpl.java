package in.bhusanproj.expensetrackerapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.bhusanproj.expensetrackerapi.entity.Expense;
import in.bhusanproj.expensetrackerapi.entity.User;
import in.bhusanproj.expensetrackerapi.entity.UserModel;
import in.bhusanproj.expensetrackerapi.exceptions.ResourceNotFoundException;
import in.bhusanproj.expensetrackerapi.exceptions.itemAlreadyExistsException;
import in.bhusanproj.expensetrackerapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
	
	public User createUser(UserModel user)
	{
		if(userRepository.existsByEmail(user.getEmail()))
		{
			throw new itemAlreadyExistsException("User already registered with email");
		}
		User newUser= new User();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(newUser.getPassword());
//		newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
		return userRepository.save(newUser);
	}
	
	public User readUser(Long id)
	{
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found for id "+id));
	}
	
	public User updateUser(UserModel user, Long id) throws ResourceNotFoundException
	{
		User ouser=readUser(id);
		ouser.setName(user.getName()!=null ? user.getName():ouser.getName());
		ouser.setEmail(user.getEmail()!=null ? user.getEmail():ouser.getEmail());
		ouser.setPassword(user.getPassword()!=null ? user.getPassword():ouser.getPassword());
//		ouser.setPassword(user.getPassword()!=null ? bcryptEncoder.encode(user.getPassword()):ouser.getPassword());
		ouser.setAge(user.getAge()!=null ? user.getAge():ouser.getAge());
		return userRepository.save(ouser);
	}
	
	public void deleteUser(Long id)
	{
		User exuser=readUser(id);
		userRepository.delete(exuser);
	}
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

}
