package com.syslogin;

import com.syslogin.entity.RoleEntity;
import com.syslogin.entity.UserEntity;
import com.syslogin.service.RoleService;
import com.syslogin.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class SysloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysloginApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService) {
		return args -> {
			roleService.addRole(new RoleEntity(null, "ROLE_USER"));
			roleService.addRole(new RoleEntity(null, "ROLE_MANAGER"));
			roleService.addRole(new RoleEntity(null, "ROLE_ADMIN"));

			userService.addUser(new UserEntity(null, "Piotr", "Piotr@info.com", "1234", new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now().minusDays(2)));
			userService.addUser(new UserEntity(null, "panek", "panek@info.com", "1234", new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now().minusDays(2)));
			userService.addUser(new UserEntity(null, "sevde", "sevde@info.com", "1234", new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now().minusDays(2)));
			userService.addUser(new UserEntity(null, "osman", "osman@info.com", "1234", new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now().minusDays(2)));
			userService.addUser(new UserEntity(null, "ali", "ali@info.com", "1234", new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now().minusDays(2)));
			userService.addUser(new UserEntity(null, "ebu", "ebu@info.com", "1234", new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now().minusDays(2)));


			userService.addRoleToUser("ROLE_USER", "Piotr");
			userService.addRoleToUser("ROLE_USER", "panek");
			userService.addRoleToUser("ROLE_MANAGER", "sevde");
			userService.addRoleToUser("ROLE_USER", "osman");
			userService.addRoleToUser("ROLE_MANAGER", "ali");
			userService.addRoleToUser("ROLE_ADMIN", "ebu");

		};
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
