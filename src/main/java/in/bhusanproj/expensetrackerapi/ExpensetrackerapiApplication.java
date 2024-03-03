package in.bhusanproj.expensetrackerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import in.bhusanproj.expensetrackerapi.controller.UserController;
import in.bhusanproj.expensetrackerapi.repository.ExpenseRepository;
import in.bhusanproj.expensetrackerapi.repository.UserRepository;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses
//	    = {
//	        ExpenseRepository.class, UserRepository.class
//	    })
public class ExpensetrackerapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerapiApplication.class, args);
	}

}
