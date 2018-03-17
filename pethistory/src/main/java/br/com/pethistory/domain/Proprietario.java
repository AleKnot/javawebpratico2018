package br.com.pethistory.domain;

public class Proprietario {

	private int proprietarioId;
	private String nome;
	private int telefone;
	private String email;

	private String rua;
	private int cep;
	private String cidade;
	private String estado;

	// construtor
	public Proprietario(String nome, int telefone, String email, String rua, int cep, String cidade, String estado) {

		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;

	}

	public Proprietario(int proprietarioId, String nome, int telefone, String email, String rua, int cep, String cidade,
			String estado) {

		this.proprietarioId = proprietarioId;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;

	}

	public int getProprietarioId() {
		return proprietarioId;
	}

	public void setProprietarioId(int proprietarioId) {
		this.proprietarioId = proprietarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	
}
