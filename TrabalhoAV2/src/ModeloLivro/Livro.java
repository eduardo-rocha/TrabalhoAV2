package ModeloLivro;

public class Livro {

	private String nome;
	private String Autor;
	private String editora;
	private int anoDeLancamento;
	
	public Livro(String nome, String autor, String editora, int anoDeLancamento) {
		super();
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

	@Override
	public String toString() {
		return "nome: " + nome + ", Autor: " + Autor + ", editora: " + editora + ", Ano de Lançamento:"
				+ anoDeLancamento;
	}
	
}
