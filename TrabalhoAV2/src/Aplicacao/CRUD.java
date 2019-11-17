package Aplicacao;

import java.util.List;
import ModeloLivro.Livro;


public interface CRUD {

	public void imprimir();
	public List<Livro> incluir(List<Livro> vetLivro, Livro livro);
	public List<Livro> excluir(List<Livro> vetLivro, Livro livro);
	public List<Livro> alterar(List<Livro> vetLivro, Livro livro);

}
