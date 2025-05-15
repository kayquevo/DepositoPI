package applicationd;

import java.util.Scanner;
import entitiesd.Estoque;
import db.EstoqueDAO;
import db.DB;

public class Program2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int escolha;
		
		Estoque estoque = new Estoque();				
		EstoqueDAO dao = new EstoqueDAO();
		
		do {
			estoque.exibirMenu();

			System.out.print("Escolha a opção: ");
			escolha = sc.nextInt();
			sc.nextLine();
			
			if (escolha == 1)
			{
				dao.compartimentosID();
				System.out.println("[0]Todos");				
				System.out.println();
				System.out.print("Insira o número correspondente : ");
				int freezerEscolhido = sc.nextInt();
				System.out.println();
				if (freezerEscolhido == 0) 
				{
					dao.consultarTodosItens(); 
				}
				dao.consultarFreezerPorId(freezerEscolhido);
				System.out.println();
			}
			else if (escolha == 2)
			{
				dao.compartimentosID();
				
				System.out.print("Escolha o compartimento; ");
				int freezerEscolhido = sc.nextInt();
				dao.consultarFreezerPorId(freezerEscolhido);
				
				dao.AdicionarItem();
				
			}
			else if (escolha == 3) 
			{
				dao.compartimentosID();
				System.out.print("Escolha o compartimento; ");
				int freezerEscolhido = sc.nextInt();
				dao.consultarFreezerPorId(freezerEscolhido);
				
				dao.removerItem();				
			}
			else if(escolha == 5)
			{				
				
				estoque.exibirMenu2();
				System.out.print("Escolha a opção: ");
				int escolha2 = sc.nextInt();
				
				sc.nextLine();
				if(escolha2 == 1)
				{
					System.out.print("Digite um nome para o compartimento: ");
					String nome = sc.nextLine();
					System.out.println();
					dao.adicionarCompartimento(nome);
					System.out.println();
				}
				else if(escolha2 == 2)
				{
					dao.consultarCompartimentos();
					System.out.println();
					System.out.print("Digite o nome do compartimento: ");					
					String nome = sc.nextLine();
					dao.removerCompartimento(nome);
				}
				else if(escolha2 == 3)
				{
					dao.consultarCompartimentos();
					System.out.println(); System.out.println();					
				}
				else if(escolha2 == 4)
				{
					System.out.print("Digite o nome do produto: ");
					String nome = sc.nextLine();					
					
					dao.compartimentosID();
					System.out.println("Digite o id na qual o item vai ser inserido: ");
					int id = sc.nextInt();
					
					dao.adicionarItemNoEstoque(nome, id, 0);	
					System.out.println();
				}
				else if(escolha2 == 5)
				{					
					System.out.println("Digite o nome do : ");
					String nome = sc.nextLine();
					dao.removerItemDoEstoque(nome);
				}
				
			}
		} while (escolha != 4);

		System.out.println("Programa encerrado!");

		sc.close();
	}
}