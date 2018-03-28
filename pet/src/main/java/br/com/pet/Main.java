package br.com.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Main extends SpringApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}


}
