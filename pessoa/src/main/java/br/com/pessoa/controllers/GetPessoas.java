package br.com.pessoa.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pessoa.domain.Pessoa;
import br.com.pessoa.services.PessoaService;
import br.com.pessoa.util.JsonConverter;


//Recebe info do PessoaService e retorna em formato JSON.


@WebServlet(name = "GetPessoas", urlPatterns = "/getpessoas")
public class GetPessoas extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json;charset=UTF-8");

		ServletOutputStream out = resp.getOutputStream();

		List<Pessoa> pessoas = new PessoaService().getPessoas();

		JsonConverter converter = new JsonConverter();

		String output = converter.convertToJson(pessoas);

		out.print(output);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		
		String birthDateAsString = req.getParameter("birthDate");
		LocalDate birthDate = null;
		try {
			if(birthDateAsString == null) {
				resp.getWriter().write("{error: 'Parameter birthDate is required'}");
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			birthDate = LocalDate.parse(birthDateAsString);
			
		} catch (DateTimeParseException e) {
			resp.getWriter().write("{error: 'Parameter releasedDate cannot be parsed'}");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String identificationAsString = req.getParameter("identification");
		double identification = Double.parseDouble(identificationAsString);
				
		String picture = req.getParameter("picture");
		
		Pessoa pessoa = new Pessoa(name, birthDate, identification, picture);
		
		PessoaService pessoaService = new PessoaService();
		
		pessoaService.save(pessoa);
		
		resp.setStatus(HttpServletResponse.SC_CREATED);
		
	}
	

}
