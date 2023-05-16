package com.github.osivaM.pp_3_1_3;

import com.github.osivaM.pp_3_1_3.models.Role;
import com.github.osivaM.pp_3_1_3.models.User;
import com.github.osivaM.pp_3_1_3.repositories.RoleRepository;
import com.github.osivaM.pp_3_1_3.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Pp313Application {

	public static void main(String[] args) {
		SpringApplication.run(Pp313Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			Role role1 = new Role("ROLE_ADMIN");
			Role role2 = new Role("ROLE_USER");

			List<Role> roles = new ArrayList<>();
			roles.add(role1);

			User user = new User("admin", "admin", (byte) 1, passwordEncoder.encode("password"), roles);
			role1.setUser(Collections.singletonList(user));


			roleRepository.save(role1);
			roleRepository.save(role2);
			userRepository.save(user);
		};
	}

}
