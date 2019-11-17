package Aplicacao;

import java.util.List;
import ModeloLivro.Livro;


public interface CRUD {

	public void imprimir(List<Livro> lista);
	public List<Livro> incluir(List<Livro> lista, Livro livro);
	public List<Livro> excluir(List<Livro> lista, Livro livro);
	public List<Livro> alterar(List<Livro> lista, Livro livro);

}
