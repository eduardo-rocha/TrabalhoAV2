package Aplicacao;

import java.util.ArrayList;
import java.util.List;

import ModeloLivro.Literario;
import ModeloLivro.Livro;

public class Principal implements CRUD {

	public static void main(String[] args) {

		List<Livro> lista = new ArrayList<Livro>();
		lista.add(new Literario("A Sociedade do Anel", "J. R. R. Tolkien", "Alien & Unwin", 1954, "Fantasia/Aventura"));
		lista.add(new Literario("As Duas Torres", "J. R. R. Tolkien", "Alien & Unwin", 1954, "Fantasia/Aventura"));
		lista.add(new Literario("O Retorno do Rei", "J. R. R. Tolkien", "Alien & Unwin", 1955, "Fantasia/Aventura"));
		
		
	}
	
	@Override
	public void imprimir(List<Livro> lista) {
		System.out.println("\n\n\n----------------------------");
		System.out.println("-- iMPRESSÃO DOS LIVROS --");
		System.out.println("\n\n\n----------------------------");
		lista.forEach( livro -> livro.toString());
		System.out.println("--------------------------------------------------------");
	}

	@Override
	public List<Livro> incluir(List<Livro> lista, Livro livro) {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Livro> excluir(List<Livro> lista, Livro livro) {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Livro> alterar(List<Livro> lista, Livro livro) {
		// TODO Auto-generated method stub
		return lista;
	}

}
