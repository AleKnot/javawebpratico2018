package br.com.pessoa.services;

import java.util.List;

import br.com.pessoa.dao.PessoaDAO;
import br.com.pessoa.domain.Pessoa;

public class PessoaService {

	PessoaDAO pessoaDAO = new PessoaDAO();
	
	public List<Pessoa> getPessoas(){
		
		return pessoaDAO.findAll();
		
	}
	
}
