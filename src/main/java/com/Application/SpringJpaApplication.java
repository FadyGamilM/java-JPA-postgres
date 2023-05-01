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
	@Bean
	CommandLineRunner commandLineRunner (StudentRepo studentRepo){
		return args -> {
/*			var magy = new Student("magy", "magdy", "magy@gmail.com", 24);
			studentRepo.save(magy);
			var fady = new Student("fady", "gamil", "fady@gmail.com", 25);
			studentRepo.save(fady);
			var ahmed = new Student("marwan", "mohammed", "marwan@gmail.com", 26);
			studentRepo.save(ahmed);
			var sa3ed = new Student("said", "mostafa", "said@gmail.com", 24);
			studentRepo.save(sa3ed);*/
/*
			var magy = new Student("magy", "magdy", "magy@gmail.com", 24);
			studentRepo.save(magy);
			studentRepo.findByEmail("fady@gmail.com")
					.ifPresentOrElse(
							System.out::println,
							()-> System.out.println("no sutdent with this email"));
			studentRepo.findByFirstNameAndLastName("fady", "gamil").ifPresentOrElse(System.out::println, () -> System.out.println("no student has been found with this first and last name combinations !"));
			studentRepo.GetByEmail("fady@gmail.com").ifPresentOrElse(
					System.out::println,
					() -> System.out.println("not found with given email")
			);

			studentRepo.GetByFirstAndLastName("fady", "gamil").ifPresentOrElse(
					System.out::println,
					() -> System.out.println("not found with given first and last name")
			);

			studentRepo.GetByEmailNative("fady@gmail.com").ifPresentOrElse(
					System.out::println,
					() -> System.out.println("not found with given email address")
			);
			System.out.println(studentRepo.DeleteStudentByStudentId(2L));


*/



		};
	}

}
