package br.com.voffice.cinema.services;

import java.util.HashMap;
import java.util.Map;

import br.com.voffice.cinema.domain.Movie;


public class MovieService {

	private static final Map<String,Movie> mapping = new HashMap<>();

	public void save(Movie movie) {
		mapping.put(movie.getKey(), movie);
	}

}
