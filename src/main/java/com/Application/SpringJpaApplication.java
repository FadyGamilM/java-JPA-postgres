package com.Application;

import com.Application.domain.Student;
import com.Application.repository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	// to run some code after the application starts
/*	@Bean
	CommandLineRunner commandLineRunner (StudentRepo studentRepo){
		return args -> {
			var fady = new Student("fady", "gamil", "fady@gmail.com", 24);
			studentRepo.save(fady);
		};
	}*/

}
