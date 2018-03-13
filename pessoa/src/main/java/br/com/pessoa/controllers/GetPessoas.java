package br.com.pessoa.controllers;

import java.io.IOException;
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

}
