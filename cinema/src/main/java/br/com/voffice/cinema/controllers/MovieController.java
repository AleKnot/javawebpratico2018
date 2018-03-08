package br.com.voffice.cinema.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.voffice.cinema.domain.Movie;
import br.com.voffice.cinema.services.MovieService;

@WebServlet("/movies")
public class MovieController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Movie ironman = new Movie("Iron Man", LocalDate.of(2008, 5, 1), 180000, "http://dsfdfdf");
		Movie thor = new Movie("Thor", LocalDate.of(2011, 5, 1), 180000, "http://dsfdfdf");
		Movie captainAmerica = new Movie("Captain America", LocalDate.of(2011, 8, 1), 180000, "http://dsfdfdf");
		List<Movie> movies = Arrays.asList(ironman, thor, captainAmerica);
		resp.setContentType("application/json");
		ObjectMapper mapper = jsonMapperSupplier.get();
		String json = mapper.writeValueAsString(movies);
		resp.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String releasedDateAsString = req.getParameter("releasedDate");
		LocalDate releasedDate = null;
		try {
		if (releasedDateAsString == null) {
			resp.getWriter().write("{error: 'Parameter releasedDate is required'}");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		 releasedDate = LocalDate.parse(releasedDateAsString);
		} catch (DateTimeParseException  e) {
			resp.getWriter().write("{error: 'Parameter releasedDate cannot be parsed'}");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String poster = req.getParameter("poster");
		String budgetAsString = req.getParameter("budget");
		Double budget = Double.parseDouble(budgetAsString);
		Movie movie = new Movie(title,releasedDate, budget, poster); //parametros viram filme
		MovieService service = new MovieService();
		service.save(movie);
		resp.setStatus(HttpServletResponse.SC_CREATED);
	}

	static final Supplier<ObjectMapper> jsonMapperSupplier = () -> {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper;
	};
}
