package ModeloLivro;

public class Academico extends Livro {

	public Academico(String nome, String autor, String editora, int anoDeLancamento) {
		super(nome, autor, editora, anoDeLancamento);
	}

	@Override
	public String toString() {
		return "Academico: " + super.toString();
	}


	
}
