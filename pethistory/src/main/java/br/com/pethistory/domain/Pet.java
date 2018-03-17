package br.com.pethistory.domain;

import java.time.LocalDate;
import java.util.Random;

public class Pet {
	
	Random gerador = new Random();
	
	int petId;
	String nome;
	int numeroTag;
	String raca;
	char sexo;
	LocalDate dataNascimento;
	String especie;
	String pelagem;
	String porte;

	public Pet(int petId, String nome, int numeroTag, String raca, char sexo, LocalDate dataNascimento, String especie,
			String pelagem, String porte) {

		this.petId = petId;
		this.nome = nome;
		this.numeroTag = numeroTag;
		this.raca = raca;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.especie = especie;
		this.pelagem = pelagem;
		this.porte = porte;
	}

	public Pet(String nome, int numeroTag, String raca, char sexo, LocalDate dataNascimento, String especie,
			String pelagem, String porte) {
		this.nome = nome;
		this.numeroTag = numeroTag;
		this.raca = raca;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.especie = especie;
		this.pelagem = pelagem;
		this.porte = porte;
	}
	
	public int getKey() {
		
		int max = 100;
		int min = 1;

		int key = gerador.nextInt(max - min + 1) + min;
		//System.out.println(key);
		
		return key;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroTag() {
		return numeroTag;
	}

	public void setNumeroTag(int numeroTag) {
		this.numeroTag = numeroTag;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	
	
	
}
