package com.Application;

import com.Application.domain.Student;
import com.Application.repository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringJpaApplication.class, args);
	}

	// to run some code after the application starts
	@Bean
	CommandLineRunner commandLineRunner (StudentRepo studentRepo){
		return args -> {
			// TODO => seed the database
/*
			var magy = new Student("magy", "magdy", "magy@gmail.com", 24);
			studentRepo.save(magy);
			var fady = new Student("fady", "gamil", "fady@gmail.com", 25);
			studentRepo.save(fady);
			var ahmed = new Student("marwan", "mohammed", "marwan@gmail.com", 26);
			studentRepo.save(ahmed);
			var sa3ed = new Student("said", "mostafa", "said@gmail.com", 24);
			studentRepo.save(sa3ed);
*/

			// TODO => SORTING BY JPA METHOD
			// NOTE-> JPA recieves the props as they are written in the domain model not in sql table
//			studentRepo.findAll(Sort.by(Sort.Direction.ASC, "firstName")).stream().map(S -> S.getFirstName()).forEach(System.out::println);
//			studentRepo.findAll(Sort.by("firstName").ascending().and(Sort.by("lastName").ascending())).forEach(System.out::println);

			// TODO => SORTING BY NATIVE SQL QUERY METHOD
//			studentRepo.SortByFirstName().stream().forEach(System.out::println);

			/*
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
			System.out.println(studentRepo.DeleteStudentByStudentId(2L));*/


		};
	}

}
