package br.com.pethistory.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.pethistory.domain.Pet;
import br.com.pethistory.services.PetServiceJSON;

@WebServlet("/petController")
public class PetControllerJSON extends HttpServlet {

	private static final long serialVersionUID = 1L;

	PetServiceJSON petService = new PetServiceJSON();

	// busca informacao
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map pets = petService.findAll();

		ObjectMapper mapper = jsonMapperSupplier.get();
		String json = mapper.writeValueAsString(pets);

		resp.getWriter().write(json);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");

		String numeroTagAsString = req.getParameter("numeroTag");
		int numeroTag = Integer.parseInt(numeroTagAsString);

		String raca = req.getParameter("raca");

		char sexo = req.getParameter("sexo").charAt(0);

		String dataNascimentoAsString = req.getParameter("dataNascimento");
		LocalDate dataNascimento = null;
		dataNascimento = LocalDate.parse(dataNascimentoAsString);

		String especie = req.getParameter("especie");

		String pelagem = req.getParameter("pelagem");

		String porte = req.getParameter("porte");
		
		Pet pet = new Pet(nome, numeroTag, raca, sexo, dataNascimento, especie, pelagem, porte);

		petService.save(pet);

		resp.setStatus(HttpServletResponse.SC_CREATED);

	}

	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		InputStream inputStream = req.getInputStream();
		
		String result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
		
		int resultAsInt = Integer.parseInt(result);
		
		petService.delete(resultAsInt);
	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InputStream inputStream = req.getInputStream();
		
		Map<String, String> map = getParameters.apply(inputStream);
		
		String petIdAsString = req.getHeader("key");
		int petId = Integer.parseInt(petIdAsString);
		System.out.println("Key from Header: " + petId);
		
	/*	
		String name = map.values().toArray()[0].toString();
		
		String numeroTagAsString = map.values().toArray()[1].toString();
				
		String raca = map.values().toArray()[2].toString();
		
		String racaAsString = map.values().toArray()[3].toString();
		
		String dataNascimentoAsString = map.values().toArray()[4].toString();
		
		String especie = map.values().toArray()[5].toString();
		
		String pelagem = map.values().toArray()[6].toString();
		
		String porte = map.values().toArray()[7].toString();
		
		
		
		Pet pet; // = new Pet();
		petService.edit(petId, pet);
		*/
	
		
	
	}
	
	public static final Function<InputStream, Map<String, String>> getParameters = is -> {
		Scanner sc = new Scanner(is);
		Map<String, String> map = new HashMap<>();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] parts = line.split("&");
			for (String part : parts) {
				if (part.split("=").length == 2) {
					String key = part.split("=")[0];
					String value = part.split("=")[1];
					map.put(key, value);
				} else {
					System.out.printf("%s not accepted %n", part);
				}
			}
		}
		sc.close();
		return map;
	};
	
	
	static final Supplier<ObjectMapper> jsonMapperSupplier = () -> {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper;
	};

}
