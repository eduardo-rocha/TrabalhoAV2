package ModeloLogin;

public class Admin extends Pessoa {

	private int codigo;
	
	public Admin(String nome, String cpf, int codigo, String login, int senha) {
		super(nome, cpf, login, senha, Permissao.TOTAL);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
