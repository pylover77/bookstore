package com.books;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.books.models.Usuario;
import com.books.models.Role;
import com.books.repository.RoleRepository;
import com.books.repository.UsuarioRepository;

@SpringBootApplication
public class BooksApplication {
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UsuarioRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			Usuario admin = new Usuario(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
		};
	}
}
