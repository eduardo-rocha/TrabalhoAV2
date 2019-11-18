package ModeloLivro;

public class Livro {

	private int codigo;
	private String nome;
	private String Autor;
	private String editora;
	private int anoDeLancamento;
	
	public Livro(int codigo, String nome, String autor, String editora, int anoDeLancamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		Autor = autor;
		this.editora = editora;
		this.anoDeLancamento = anoDeLancamento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}
	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + ", Nome: " + nome + ", Autor: " + Autor + ", Editora: " + editora + ", Ano de Lançamento: "
				+ anoDeLancamento;
	}
}
