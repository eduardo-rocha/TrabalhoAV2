package ModeloLivro;

public class Literario extends Livro {

	private String estilo;
	
	public Literario(String nome, String autor, String editora, int anoDeLancamento, String estilo) {
		super(nome, autor, editora, anoDeLancamento);
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
		return "Literario: estilo: " + estilo + ", " + super.toString();
	}


}
