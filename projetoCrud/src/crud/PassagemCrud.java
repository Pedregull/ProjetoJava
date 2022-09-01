package crud;

import java.util.Scanner;

import dao.PassagemDAO;
import modelo.Passagem;

public class PassagemCrud {

	public static void main(String[] args) {
		
		PassagemDAO PassagemDAO = new PassagemDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;
		int id = 0;
        double preco = 0;
		String nome = "";
		

		do {
			System.out.println("=== CRUD Passagem ===");
			System.out.println("1 - Cadastrar Passagem");
			System.out.println("2 - Consultar Passagem");
			System.out.println("3 - Atualizar Passagem");
			System.out.println("4 - Deletar Passagem");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome do local da Passagem(a): ");
				nome = s.nextLine();
			
				System.out.println("Digite o preço da Passagem: ");
				preco = s.nextDouble();
				s.nextLine();
				
				Passagem p1 = new Passagem(id, nome, preco);
				
				PassagemDAO.save(p1);
				
				System.out.println("\n***  Cadastrado  ***\n");

				break;
			case 2:
				// READ
				for (Passagem a : PassagemDAO.getPassagem()) {
					System.out.println("ID: " + a.getId() + " Nome: " + a.getNome() + " Preço: " + a.getPreco());
				}
				
				System.out.println("Consultado");
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o ID da Passagem(a): ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o novo local da Passagem(a): ");
				nome = s.nextLine();
				
				Passagem a2 = new Passagem(posicao, nome);
			
				PassagemDAO.update(a2);
	
				System.out.println("Atualizado");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o ID da Passagem(a): ");
				posicao = s.nextInt();
				
				PassagemDAO.deleteById(posicao);
				
				break;
			case 5:
				// buscar por id
				System.out.println("Digite o ID da Passagem(a): ");
				posicao = s.nextInt();
				
				Passagem a3 = PassagemDAO.getPassagemById(posicao);
				
				System.out.println("Id: " + a3.getId() + " Nome: " + a3.getNome() + " Preço: " + a3.getPreco());
				
				break;
			default:
				System.out.println(opcao != 0 ? "opção inválida, digite novamente." : "");
				break;

			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();
	}

}
