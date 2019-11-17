package Modelo;

public class Pessoa {

	private String nome;
	private String cpf;
	private int idade;
	private Permissao permissao;
	
	public Pessoa(String nome, String cpf, int idade, Permissao permissao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.permissao = permissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	
}
