package Aplicacao;

import java.util.ArrayList;
import java.util.List;

import ModeloLivro.Academico;
import ModeloLivro.Literario;
import ModeloLivro.Livro;
import ModeloLogin.Admin;
import ModeloLogin.Pessoa;
import ModeloLogin.Usuario;

public class Principal{

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Eduardo", "111111", "eduardo.rocha", 1234);
		Admin admin = new Admin("Richard", "222222", "richard.bruno", 4321);
		
		List<Livro> lista = new ArrayList<Livro>();
		lista.add(new Literario(1, "A Sociedade do Anel", "J. R. R. Tolkien", "Alien & Unwin", 1954, "Fantasia/Aventura"));
		lista.add(new Literario(2, "As Duas Torres", "J. R. R. Tolkien", "Alien & Unwin", 1954, "Fantasia/Aventura"));
		lista.add(new Literario(3, "O Retorno do Rei", "J. R. R. Tolkien", "Alien & Unwin", 1955, "Fantasia/Aventura"));
		lista.add(new Academico(4, "Java Efetivo", "Joshua Bloch", "Alta Books", 2001));
		
		Menu menu = new Menu();
		
		Pessoa pessoa = menu.login(usuario, admin);
		if (pessoa != null) {
			boolean chave = true;
			while (chave) {
				
				if (pessoa instanceof Usuario)
					menu.opcao = menu.menu((Usuario)pessoa);
				else if (pessoa instanceof Admin)
					menu.opcao = menu.menu((Admin)pessoa);
				
				if (menu.opcao == 0)
					chave = !chave;
				
				else if (menu.opcao == 1)
					menu.imprimir(lista);
				else if (menu.opcao == 2) {
					lista.add(Menu.lerDados(lista));
				} else if (menu.opcao == 3) {
					lista = menu.alterar(lista);
				} else if (menu.opcao == 4)
					lista = menu.excluir(lista);
			}
		}
	}
}
