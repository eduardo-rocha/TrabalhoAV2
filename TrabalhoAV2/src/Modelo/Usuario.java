package Modelo;

public class Usuario extends Pessoa {

	public Usuario(String nome, String cpf, String login, int senha) {
		super(nome, cpf, login, senha, Permissao.PARCIAL);
	}
}
