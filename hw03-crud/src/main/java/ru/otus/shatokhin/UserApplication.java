package ru.otus.shatokhin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("${web.root}")
public class UserApplication {

	@Value("${spring.datasource.url}")
	private static String dbUrl;

	@Value("${spring.datasource.password}")
	private static String dbPassword;

	@Value("${spring.datasource.username}")
	private static String dbUser;

	public static void main(String[] args) {
		System.out.println("CRUD application starting...\n\n"
				+ "DB_URL=" + dbUrl + "\n"
				+ "DB_PASSWORD=" + dbPassword + "\n"
				+ "DB_USER_NAME=" + dbUser + "\n");

		SpringApplication.run(UserApplication.class, args);
	}

}
