package br.com.pet.bean;

import java.time.LocalDate;

public class Pet {

	//private String name;
	//private String localDate;
	
	private String nome;
	private int numeroTag;
	private String raca;
	private char sexo;
	private LocalDate dataNascimento;
	private String especie;
	private String pelagem;
	private String porte;
	
	
		
	public Pet(String nome, int numeroTag, String raca, char sexo, LocalDate dataNascimento, String especie,
			String pelagem, String porte) {
		super();
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
		return numeroTag;
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
