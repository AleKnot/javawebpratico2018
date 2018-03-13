package br.com.pessoa.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.pessoa.domain.Pessoa;

public class PessoaDAO {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public List<Pessoa> findAll() {

		pessoas.add(new Pessoa("Mac Gayver", LocalDate.of(2008, 5, 1), 12365488,
				"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));
		pessoas.add(new Pessoa("Rambo", LocalDate.of(2008, 5, 1), 12365488,
				"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));
		pessoas.add(new Pessoa("Chuck Norris", LocalDate.of(2008, 5, 1), 12365488,
				"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));
		pessoas.add(new Pessoa("Bruce Lee", LocalDate.of(2008, 5, 1), 12365488,
				"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"));

		return pessoas;

	}

	public void save(Pessoa pessoa) {

		pessoas.add(pessoa);

	}

}