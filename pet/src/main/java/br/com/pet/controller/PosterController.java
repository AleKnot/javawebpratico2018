package br.com.pet.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import org.springframework.web.bind.annotation.GetMapping;

@MultipartConfig
@WebServlet("/poster")
public class PosterController {
	
	@GetMapping("/savePoster")
	public void savePoster() {
		
		
	}

}
