package br.com.bootsandbox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.bootsandbox.bean.Movie;
import br.com.bootsandbox.repository.MovieRepository;
import br.com.bootsandbox.service.MovieService;

@Configuration
@ComponentScan
public class MovieConfiguration {


	public MovieService provideMovieService() {
		return new MovieService();
	}

	@Bean
	public MovieRepository provideRepository() {
		return new MovieRepository() {

			@Override
			public boolean create(Movie movie) {
				System.out.println("salvando em disco");
				return false;
			}

		};
	}
	
	
}
