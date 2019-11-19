package Aplicacao;

import java.util.List;
import java.util.Scanner;

import ModeloLivro.Academico;
import ModeloLivro.Literario;
import ModeloLivro.Livro;
import ModeloLogin.Admin;
import ModeloLogin.Permissao;
import ModeloLogin.Pessoa;
import ModeloLogin.Usuario;

public class Menu implements CRUD {

	static Scanner leitor = new Scanner(System.in);
	
	public int opcao;
	
	// Controle de Login e Senha
	public Pessoa login(Usuario usuario, Admin admin) {
		System.out.print("Digite o Login: ");
		String login = leitor.next();
		System.out.print("Digite a Senha: ");
		int senha = leitor.nextInt();
		
		if (login.equals(usuario.getLogin()) && senha == usuario.getSenha()) {
			System.out.println("Acesso Permitido!");
			return usuario;
		}
		else if (login.equals(admin.getLogin()) && senha == admin.getSenha()) {
			System.out.println("Acesso Permitido");
			return admin;
		} else
			System.out.println("Acesso negado!");
		return null;
	}
	
	
	// POLIMORFISMO
	// Menu do usu�rio com Permiss�o Total (Admin)
	public int menu(Admin admin) {

		System.out.println("--------------------------");
		System.out.println("\nO que voc� deseja?\n");
		System.out.println("1 - Ver Livros Dispon�veis;");
		System.out.println("2 - Incluir Livro;");
		System.out.println("3 - Alterar Livro;");
		System.out.println("4 - Excluir Livro;");
		System.out.println("0 - Sair.");

		opcao = leitor.nextInt();
		
		if (opcao > 0 || opcao < 4 && admin.getPermissao() == Permissao.TOTAL) {
			System.out.println("Autorizado");
			return opcao;
		}
		else
			System.out.println("Opcao inv�lida!");
		return 0;
	}
	
	// Menu do usu�rio com permiss�o Parcial (Apenas leitura) (Usu�rio)
	public int menu(Usuario usuario) {

		System.out.println("--------------------------");
		System.out.println("\nO que voc� deseja?\n");
		System.out.println("1 - Ver Livros Dispon�veis;");
		System.out.println("0 - Sair.");

		opcao = leitor.nextInt();

		if (opcao == 1 || opcao == 0 && usuario.getPermissao() == Permissao.PARCIAL) {
			System.out.println("Autorizado");
			return opcao;
		}
		else
			System.out.println("Opcao inv�lida!");
		return 0;
	}
	
	
	// Sistema CRUD - Creat, Read, Update, Delete
	// M�todo de Impress�o de Dados: Sistema CRUD - READ
	@Override
	public void imprimir(List<Livro> lista) {
		System.out.println("1- Impress�o Geral");
		System.out.println("2- Impress�o por C�digo");
		System.out.println("3- Por ano de lan�amento");
		System.out.println("4- De um autor espec�fico;");
		
		int escolha = leitor.nextInt();
		if (escolha == 1) {
			System.out.println("\n--------------------------");
			System.out.println("-- iMPRESS�O DOS LIVROS --");
			System.out.println("--------------------------");
			
			lista.forEach(livro -> System.out.println(livro.toString()));
		} else if (escolha == 2) {
				System.out.println("\n----------------------------------------------");
				System.out.println("-- iMPRESS�O DOS LIVROS ORDENADA POR C�DIGO --");
				System.out.println("----------------------------------------------");
				
				lista.sort( (o1, o2) -> ((Integer)o1.getCodigo()).compareTo(o2.getCodigo()));
				lista.forEach(livro -> System.out.println(livro.toString()));
		} else if (escolha == 3) {
			System.out.println("\n---------------------------------------------------------");
			System.out.println("-- iMPRESS�O DOS LIVROS ORDENADA POR ANO DE LAN�AMENTO --");
			System.out.println("---------------------------------------------------------");
			
			lista.sort( (o1, o2) -> ((Integer)o1.getAnoDeLancamento()).compareTo(o2.getAnoDeLancamento()));
			lista.forEach(livro -> System.out.println(livro.toString()));
			lista.sort( (o1, o2) -> ((Integer)o1.getCodigo()).compareTo(o2.getCodigo()));
		} else if (escolha == 4) {
			System.out.println("Substitua espa�os por h�fen -");
			System.out.print("Digite o nome do autor: ");
			String autor = leitor.next();
			System.out.println("\n-----------------------------------------------------------------");
			System.out.println("-- iMPRESS�O DOS LIVROS DO AUTOR: " + autor + " --");
			System.out.println("-----------------------------------------------------------------");
		
			lista.forEach(livro -> {
				if (livro.getAutor().equals(autor))
					System.out.println(livro.toString());
			});
		} else
			System.out.println("Op��o inv�lida!");
	}
	

	// M�todo de Exclus�o de Dados: Sistema CRUD - DELETE
	// M�todo de Exclus�o de Dados: Sistema CRUD - DELETE
	@Override
	public List<Livro> excluir(List<Livro> lista) {
		System.out.print("Digite o c�digo do Livro a ser exclu�do: ");
		int cod = leitor.nextInt();

		boolean chave = true;
		for (int i = 0; i < lista.size() && chave; i++) {
			if (lista.get(i).getCodigo() == cod) {
				lista.remove(i);
				chave = !chave;
			} else if (i == lista.size()-1)
				System.out.println("\nEsse livro n�o existe no cat�logo!");
		}
		return lista;
	}


	// M�todo de Altera��o de Dados: Sistema CRUD - UPDATE
	// M�todo de Altera��o de Dados: Sistema CRUD - UPDATE
	@Override
	public List<Livro> alterar(List<Livro> lista) {
		
		System.out.print("Digite o c�digo do livro que voc� deseja alterar: ");
		int cod = leitor.nextInt();
		
		boolean chave = true;
		for (int i = 0; i < lista.size() && chave; i++) {
			
			if (lista.get(i).getCodigo() == cod) {
				Livro livro = lista.get(i);
				lista.remove(i);
				chave = !chave;
				
				if (livro instanceof Academico) {
					livro = (Academico)livro;
					System.out.println("O que voc� deseja alterar?");
					System.out.println("1- Nome \n2- Autor \n3- Editora \n4- Ano de Lan�amento;");
				} else if (livro instanceof Literario) {
					livro = (Literario)livro;
					System.out.println("O que voc� deseja alterar?");
					System.out.println("1- Nome \n2- Autor \n3- Editora \n4- Ano de Lan�amento \n5- Estilo;");
				}
				
				int escolha = leitor.nextInt();
				
				if (escolha == 1) {
					System.out.print("Insira o nome do livro: ");
					livro.setNome(leitor.next());
				} else if (escolha == 2) {
					System.out.print("Insira o nome do autor: ");
					livro.setAutor(leitor.next());
				} else if (escolha == 3) {
					System.out.print("Insira o nome da editora: ");
					livro.setEditora(leitor.next());
				} else if (escolha == 4) {
					System.out.print("Insira o ano de lan�amento: ");
					livro.setAnoDeLancamento(leitor.nextInt());
				} else if (escolha == 5 && livro instanceof Literario) {
						System.out.print("Insira o estilo: ");
						((Literario) livro).setEstilo(leitor.next());
				} else {
					System.out.println("Op��o inv�lida!");
				}
				
				lista.add(i, livro);
			} else if (i == lista.size()-1)
				System.out.println("\nEsse livro n�o existe no cat�logo!");
		}
		return lista;
	}
	

	// M�todo de Inclus�o de Dados: Sistema CRUD - CREAT
	// M�todo de Inclus�o de Dados: Sistema CRUD - CREAT
	@Override
	public Livro incluir(List<Livro> lista) {
		
		System.out.println("1- Acad�mico\n2- Liter�rio");
		int escolha = leitor.nextInt();
		if (escolha == 1) {
			
			int codigo = 0;
			// La�o para a verifica��o do c�digo
			boolean chave = true;
			while (chave) {
				
				System.out.println("Insira o c�digo do Livro: ");
				codigo = leitor.nextInt();
				
				// Varificando se o c�digo est� repetido
				boolean repetido = false;
				for (Livro livro : lista) {
					if (livro.getCodigo() == codigo) {
						System.out.println("C�digo inv�lido!");
						repetido = true;
					}
				}
				if (!repetido)
					chave = !chave;
			}
			
			System.out.print("Insira o nome do livro: ");
			String nome = leitor.next();
			
			System.out.print("Insira o Autor do Livro: ");
			String autor = leitor.next();
			
			System.out.print("insira a Editora: ");
			String editora = leitor.next();
			
			System.out.print("Insira o ano de lan�amento: ");
			int anoDeLacamento = leitor.nextInt();
			
			Academico livro = new Academico(codigo, nome, autor, editora, anoDeLacamento);
			
			return livro;
		} else if (escolha == 2) {
			
			int codigo = 0;
			// La�o para a verifica��o do c�digo
			boolean chave = true;
			while (chave) {
				
				System.out.println("Insira o c�digo do Livro: ");
				codigo = leitor.nextInt();
				
				// Varificando se o c�digo est� repetido
				boolean repetido = false;
				for (Livro livro : lista) {
					if (livro.getCodigo() == codigo) {
						System.out.println("C�digo inv�lido!");
						repetido = true;
					}
				}
				if (!repetido)
					chave = !chave;
			}
			
			System.out.print("Insira o nome do livro: ");
			String nome = leitor.next();
			
			System.out.print("Insira o Autor do Livro: ");
			String autor = leitor.next();
			
			System.out.print("insira a Editora: ");
			String editora = leitor.next();
			
			System.out.print("Insira o ano de lan�amento: ");
			int anoDeLacamento = leitor.nextInt();
			
			System.out.print("Insira o estilo do livro: ");
			String estilo = leitor.next();
			
			Literario livro = new Literario(codigo, nome, autor, editora, anoDeLacamento, estilo);
			
			return livro;
		} 
		else
			return null;
	}
}
