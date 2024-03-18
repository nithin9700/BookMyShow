package dev.sandeep.BookMyShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {SecurityException.class})
public class BookMyShowApplication {
	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}
}
