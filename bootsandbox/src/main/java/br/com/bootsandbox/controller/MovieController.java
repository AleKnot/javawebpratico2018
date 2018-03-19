package br.com.bootsandbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bootsandbox.bean.Movie;
import br.com.bootsandbox.service.MovieService;

@Controller
@EnableAutoConfiguration
public class MovieController {

	
	@Autowired
	private MovieService service;
	
	@GetMapping("/")
	@ResponseBody
	public String getHello(@RequestParam(required=false) String name) {
		return (name);
	}

	@GetMapping("/{name}")
	@ResponseBody
	public String getHelloPathVariable(@PathVariable String name) {
		return "path "+(name);
	}

	@GetMapping("/movies")
	@ResponseBody
	public List<Movie> getMovies() {
		return service.findAll();
	}

	
	
	
}
