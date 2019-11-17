package Modelo;

public class Usuario extends Pessoa {

	public Usuario(String nome, String cpf, int idade) {
		super(nome, cpf, idade, Permissao.PARCIAL);
	}
}
