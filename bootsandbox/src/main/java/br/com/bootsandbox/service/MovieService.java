package br.com.bootsandbox.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import br.com.bootsandbox.bean.Movie;
import br.com.bootsandbox.repository.MovieRepository;

@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MovieService {


	@Autowired
	private MovieRepository repository;

	public boolean create (Movie movie) {
		this.repository.create(movie);
		System.out.println(movie);
		return true;
	}

	public List<Movie> findAll() {
		return Arrays.asList(new Movie("Black Panther","2018-04-16"),new Movie("Avengers: Infinity War","2018-06-25"));
	}
	
	
	
}
