package br.com.voffice.cinema.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.voffice.cinema.domain.Movie;

@WebServlet({"/attributes","/attribute.json", "/attributes.html","/attribute.xml"})
public class AttributeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Map<String,String> capitais = new HashMap<String,String>() {
		{
			put("SC","Floripa");
			put("RS","Porto Alegre");
			put("PR","Curitiba");
		}
	};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String uf = req.getParameter("UF");
		String extension = req.getParameter("extension");
		extension = extension == null? "plain": extension;
		String capital = capitais.get(uf);
		req.setAttribute("capital", capital);
		String target = null;
		switch (extension) {
		case "json": target = "/attributeJSON"; break;
		case "html": target = "/attributeHTML"; break;
		case "xml": target = "/attributeXML"; break;
		default: target = "/capital.jsp"; break;
		}
		Movie ironman = new Movie("Iron Man", LocalDate.of(2008, 5, 1), 180000, "http://dsfdfdf");
		Movie thor = new Movie("Thor", LocalDate.of(2011, 5, 1), 180000, "http://dsfdfdf");
		Movie captainAmerica = new Movie("Captain America", LocalDate.of(2011, 8, 1), 180000, "http://dsfdfdf");
		List<Movie> movies = Arrays.asList(ironman, thor, captainAmerica);
		req.setAttribute("movies", movies);
		req.getRequestDispatcher(target).forward(req, resp);
	}
}








