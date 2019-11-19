package ModeloLogin;

public class Usuario extends Pessoa {

	private int matricula;
	
	public Usuario(String nome, String cpf, int matricula, String login, int senha) {
		super(nome, cpf, login, senha, Permissao.PARCIAL);
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
}
