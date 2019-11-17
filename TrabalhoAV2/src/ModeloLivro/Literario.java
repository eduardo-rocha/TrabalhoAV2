package ModeloLivro;

public class Literario extends Livro {

	private String estilo;
	
	public Literario(int codigo, String nome, String autor, String editora, int anoDeLancamento, String estilo) {
		super(codigo, nome, autor, editora, anoDeLancamento);
		this.estilo = estilo;
	}
	
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "\nLiterario: \nEstilo: " + estilo + ", " + super.toString();
	}
}
