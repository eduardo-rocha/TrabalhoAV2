package Aplicacao;

import java.util.List;
import ModeloLivro.Livro;


public interface CRUD {

	public void imprimir(List<Livro> lista);
	public List<Livro> excluir(List<Livro> lista);
	public List<Livro> alterar(List<Livro> lista);
}
