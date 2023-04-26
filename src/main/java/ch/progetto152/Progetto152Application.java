package ch.progetto152;

import ch.progetto152.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Progetto152Application {

	public static void main(String[] args) {
		SpringApplication.run(Progetto152Application.class, args);
	}

	@Bean
	public UserController newController() {
		return new UserController();
	}

}