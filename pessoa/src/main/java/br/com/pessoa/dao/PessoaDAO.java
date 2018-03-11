package br.com.pessoa.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pessoa.domain.Pessoa;

public class PessoaDAO {
	
	public List<Pessoa> findAll(){
		
		List<Pessoa> pessoas = new ArrayList();
		
		pessoas.add(new Pessoa("Mac Gayver", LocalDate.of(22, 12, 1987), 12365488, "https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));
		pessoas.add(new Pessoa("Rambo", LocalDate.of(22, 12, 1987), 12365488, "https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));
		pessoas.add(new Pessoa("Chuck Norris", LocalDate.of(22, 12, 1987), 12365488, "https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));
		pessoas.add(new Pessoa("Bruce Lee", LocalDate.of(22, 12, 1987), 12365488, "https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));
		
		
		return pessoas;
		
		
		
		
	}

}
