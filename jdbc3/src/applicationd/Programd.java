package applicationd;

import java.util.Scanner;
import entitiesd.Estoque;
import db.EstoqueDAO;
import db.DB;

public class Programd
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int escolha;
		
		Estoque estoque = new Estoque();				
		EstoqueDAO dao = new EstoqueDAO();
		
		do {
			estoque.exibirMenu();

			System.out.println("Escolha a opção: ");
			escolha = sc.nextInt();
			if (escolha == 1)
			{
				System.out.println("[0]Todos");
				estoque.exibirFreezers();

				System.out.println();
				System.out.print("Insira o número correspondente : ");

				int freezerEscolhido = sc.nextInt();

				System.out.println();
				if (freezerEscolhido == 0) 
				{
					dao.consultarTodosItens(); 
				}
				else if (freezerEscolhido == 1) 
				{
					dao.consultarFreezer1();
				} 
				else if (freezerEscolhido == 2) 
				{
					dao.consultarFreezer2();
				} 
				else if (freezerEscolhido == 3) 
				{
					dao.consultarFreezer3();
				} 
				else if (freezerEscolhido == 4) 
				{
					dao.consultarFreezer4();
				}
				System.out.println();
			}
			else if (escolha == 2)
			{
				estoque.exibirFreezers();

				int freezerEscolhido = sc.nextInt();

				if (freezerEscolhido == 1) 
				{
					dao.consultarFreezer1();				
					dao.AdicionarItem();					
				}
				if (freezerEscolhido == 2)
				{
					dao.consultarFreezer2();					
					dao.AdicionarItem();					
				}
				if (freezerEscolhido == 3)
				{
					dao.consultarFreezer3();					
					dao.AdicionarItem();					
				}
				if (freezerEscolhido == 4)
				{
					dao.consultarFreezer4();					
					dao.AdicionarItem();
				}
			}
			else if (escolha == 3) 
			{
				estoque.exibirFreezers();

				int freezerEscolhido = sc.nextInt();

				if (freezerEscolhido == 1) 
				{
					dao.consultarFreezer1();				
					dao.removerItem();
				}
				if (freezerEscolhido == 2) 
				{
					dao.consultarFreezer2();				
					dao.removerItem();
				}
				if (freezerEscolhido == 3) 
				{
					dao.consultarFreezer3();				
					dao.removerItem();
				}
				if (freezerEscolhido == 4) 
				{
					dao.consultarFreezer4();				
					dao.removerItem();
				}
			}
		} while (escolha != 4);

		System.out.println("Programa encerrado!");

		sc.close();
	}
}