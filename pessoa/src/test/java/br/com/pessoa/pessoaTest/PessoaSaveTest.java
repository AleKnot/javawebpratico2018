package br.com.pessoa.pessoaTest;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.pessoa.dao.PessoaDAO;
import br.com.pessoa.domain.Pessoa;
import br.com.pessoa.services.PessoaService;
import br.com.pessoa.util.JsonConverter;

@SuppressWarnings("unused")
public class PessoaSaveTest {

	@Test
	public void pessoaSave() {

		PessoaDAO pessoaDAO = new PessoaDAO();

		Pessoa pessoa = new Pessoa("Alex Teste", LocalDate.of(2008, 5, 1), 12365488,
				"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg");

		pessoaDAO.save(pessoa);
		
		List<Pessoa> pessoas = pessoaDAO.findAll();
		
		JsonConverter converter = new JsonConverter();

		String output = converter.convertToJson(pessoas);
		System.out.println(output);
		

	}

}
