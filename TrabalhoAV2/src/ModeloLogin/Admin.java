package ModeloLogin;

public class Admin extends Pessoa {

	public Admin(String nome, String cpf, String login, int senha) {
		super(nome, cpf, login, senha, Permissao.TOTAL);
	}
}
