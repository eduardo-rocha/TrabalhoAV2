package Modelo;

public class Admin extends Pessoa {

	public Admin(String nome, String cpf, int idade) {
		super(nome, cpf, idade, Permissao.TOTAL);
	}

}
