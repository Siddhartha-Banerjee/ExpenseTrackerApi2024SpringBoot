package in.bhusanproj.expensetrackerapi.entity;

import java.beans.JavaBean;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {

	@NotBlank(message="name should not be empty")
	private String name;
	
	@NotNull(message="email id is must")
	@Email(message="enter a valid email")
	private String email;
	
	@NotNull(message="pw is must")
	@Size(min=3,message="password should have atleast 3 char")
	private String password;
	
	private Long age=0L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	
	
	
}
