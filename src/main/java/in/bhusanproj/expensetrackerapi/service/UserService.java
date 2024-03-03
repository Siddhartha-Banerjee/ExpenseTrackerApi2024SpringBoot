package in.bhusanproj.expensetrackerapi.service;

import java.util.List;

import in.bhusanproj.expensetrackerapi.entity.User;
import in.bhusanproj.expensetrackerapi.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel user);
	User readUser(Long id);
	User updateUser(UserModel user, Long id);
	void deleteUser(Long id);
	List<User> getAllUsers();

}
