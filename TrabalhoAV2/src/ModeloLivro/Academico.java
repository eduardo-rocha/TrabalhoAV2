package ModeloLivro;

public class Academico extends Livro {

	public Academico(int codigo, String nome, String autor, String editora, int anoDeLancamento) {
		super(codigo, nome, autor, editora, anoDeLancamento);
	}

	@Override
	public String toString() {
		return "\nAcademico: \n" + super.toString();
	}
}
