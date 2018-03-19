package br.com.pessoa.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pessoa.dao.PessoaDAO;
import br.com.pessoa.domain.Pessoa;
import br.com.pessoa.services.PessoaService;

@SuppressWarnings("unused")
@WebServlet("/setPessoa")
public class SetPessoa extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
		
		//PessoaService pessoaService = new PessoaService();
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.save(pessoa);
		
		
		resp.setStatus(HttpServletResponse.SC_CREATED);
	}

}
