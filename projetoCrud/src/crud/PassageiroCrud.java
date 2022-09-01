package crud;

import java.util.Scanner;

import dao.PassageiroDAO;
import modelo.Passageiro;

public class PassageiroCrud {

	public static void main(String[] args) {
		
		PassageiroDAO passageiroDAO = new PassageiroDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;
		int id = 0;

		String nome = "";
		

		do {
			System.out.println("=== CRUD Passageiro ===");
			System.out.println("1 - Cadastrar Passageiro");
			System.out.println("2 - Consultar Passageiro");
			System.out.println("3 - Atualizar Passageiro");
			System.out.println("4 - Deletar Passageiro");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome do passageiro(a): ");
				nome = s.nextLine();
			
				
				Passageiro a1 = new Passageiro(id, nome);
				
				PassageiroDAO.save(a1);
				
				System.out.println("\n***  Cadastrado  ***\n");

				break;
			case 2:
				// READ
				for (Passageiro a : passageiroDAO.getPassageiro()) {
					System.out.println("ID: " + a.getId() + " Nome: " + a.getNome());
				}
				
				System.out.println("Consultado");
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o ID do passageiro(a): ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o novo nome do passageiro(a): ");
				nome = s.nextLine();
				
				Passageiro a2 = new Passageiro(posicao, nome);
			
				passageiroDAO.update(a2);
	
				System.out.println("Atualizado");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o ID do passageiro(a): ");
				posicao = s.nextInt();
				
				passageiroDAO.deleteById(posicao);
				
				break;
			case 5:
				// buscar por id
				System.out.println("Digite o ID do passageiro(a): ");
				posicao = s.nextInt();
				
				Passageiro a3 = passageiroDAO.getpassageiroById(posicao);
				
				System.out.println("Id: " + a3.getId() + " Nome: " + a3.getNome());
				
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
