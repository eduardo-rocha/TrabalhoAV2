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
	
	int opcao;
	
	
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
	
	
	
	
	
	public int menu(Admin admin) {

		System.out.println("--------------------------");
		System.out.println("\nO que você deseja?\n");
		System.out.println("1 - Ver Livros Disponíveis;");
		System.out.println("2 - Incluir Livro;");
		System.out.println("3 - Alterar Livro;");
		System.out.println("4 - Excluir Livro;");
		System.out.println("0 - Sair.");

		opcao = leitor.nextInt();
		
		if (opcao > 0 || opcao < 4 && admin.getPermissao() == Permissao.TOTAL)
			System.out.println("Autorizado");
		else
			System.out.println("Opcao inválida!");
		
	return opcao;
	}
	public int menu(Usuario usuario) {

		System.out.println("--------------------------");
		System.out.println("\nO que você deseja?\n");
		System.out.println("1 - Ver Livros Disponíveis;");
		System.out.println("0 - Sair.");

		opcao = leitor.nextInt();

		if (opcao == 1 && usuario.getPermissao() == Permissao.PARCIAL)
			System.out.println("Autorizado");
		else
			System.out.println("Opcao inválida!");
		
	return opcao;
	}
	
	@Override
	public void imprimir(List<Livro> lista) {
		System.out.println("--------------------------");
		System.out.println("-- iMPRESSÃO DOS LIVROS --");
		System.out.println("--------------------------");
		
		lista.forEach(livro -> System.out.println(livro.toString()));
		
		System.out.println("--------------------------------------------------------");
	}

	@Override
	public List<Livro> excluir(List<Livro> lista) {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Livro> alterar(List<Livro> lista, Livro livro) {
		// TODO Auto-generated method stub
		return lista;
	}
	
	public static Livro lerDados(List<Livro> lista) {
		
		System.out.println("1- Acadêmico\n2- Literário");
		
		if (leitor.nextInt() == 1) {
			
			int codigo = 0;
			// Laço para a verificação do código
			boolean chave = true;
			while (chave) {
				
				System.out.println("Insira o código do Livro: ");
				codigo = leitor.nextInt();
				
				// Varificando se o código está repetido
				boolean repetido = false;
				for (Livro livro : lista) {
					if (livro.getCodigo() == codigo)
						System.out.println("Código inválido!");
						repetido = true;
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
			
			System.out.print("Insira o ano de lançamento: ");
			int anoDeLacamento = leitor.nextInt();
			Academico livro = new Academico(codigo, nome, autor, editora, anoDeLacamento);
			
			return livro;
		}
		if (leitor.nextInt() == 2) {
			
			int codigo = 0;
			// Laço para a verificação do código
			boolean chave = true;
			while (chave) {
				
				System.out.println("Insira o código do Livro: ");
				codigo = leitor.nextInt();
				
				// Varificando se o código está repetido
				boolean repetido = false;
				for (Livro livro : lista) {
					if (livro.getCodigo() == codigo)
						System.out.println("Código inválido!");
						repetido = true;
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
			
			System.out.print("Insira o ano de lançamento: ");
			int anoDeLacamento = leitor.nextInt();
			
			System.out.print("Qual o estilo do livro?");
			String estilo = leitor.next();
			Literario livro = new Literario(codigo, nome, autor, editora, anoDeLacamento, estilo);
			
			return livro;
		} 
		else
			return null;
	}
}
