package view;

import java.util.Scanner;

import dao.ContatosDao;
import model.Contatos;

public class Main {

	public static void main(String[] args) {
		 //inserirContatos();
		 listarContatos();
		// deletarContatos();
		// editarContatos();
	}

	// Create
	public static void inserirContatos() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Contatos c = new Contatos();

		System.out.println("Digite o Nome:");
		c.setNome(input.nextLine());

		System.out.println("Digite o E-mail:");
		c.seteMail(input.nextLine());

		System.out.println("Digite o Telefone:");
		c.setTelefone(input.nextLine());

		ContatosDao dao = new ContatosDao();
		dao.inserir(c);

		System.out.println("Contato adicionado com Sucesso!");

	}

	// Read
	public static void listarContatos() {
		ContatosDao dao = new ContatosDao();

		for (Contatos p : dao.listar()) {
			System.out.println(p.toString());
			
			
		}
	}

	// Update
	public static void editarContatos() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Contatos c = new Contatos();

		System.out.println("Qual contato pelo ID você deseja editar?");
		c.setId(input.nextInt());

		ContatosDao dao = new ContatosDao();
		dao.delete(c);
		
		c.setNome(input.nextLine());
		
		System.out.println("Digite o novo Nome:");
		c.setNome(input.nextLine());

		System.out.println("Digite o novo E-mail:");
		c.seteMail(input.nextLine());

		System.out.println("Digite o novo Telefone:");
		c.setTelefone(input.nextLine());

		dao.inserir(c);

		System.out.println("Contato atualizado!");

	}

	// Delete
	public static void deletarContatos() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Contatos c = new Contatos();

		System.out.println("Digite o numero do ID para deletar:");
		c.setId(input.nextInt());

		ContatosDao dao = new ContatosDao();
		dao.delete(c);

		System.out.println("Contato Deletada!");
	}
}