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

		    switch (escolha) {
		        case 1:
		            dao.compartimentosID();
		            System.out.println("[0]Todos");				
		            System.out.println();
		            System.out.print("Insira o número correspondente : ");
		            
		            int freezerEscolhido1 = sc.nextInt();
		            System.out.println();
		            
		            if (freezerEscolhido1 == 0) {
		                dao.consultarTodosItens(); 
		            }
		            dao.consultarFreezerPorId(freezerEscolhido1);
		            System.out.println();
		            break;

		        case 2:
		        	char decisao;
		        	do
		        	{		        		
		            dao.compartimentosID();
		            System.out.print("Escolha o compartimento: ");
		            int freezerEscolhido2 = sc.nextInt();
		            
		            dao.consultarFreezerPorId(freezerEscolhido2);

		            	dao.AdicionarItem();
		            	System.out.print("Deseja continuar?(s/n): ");
		            	sc.nextLine();
		            	decisao = sc.nextLine().charAt(0);		            	
		            	
		            }while (decisao != 'n');	
		            
		            break;

		        case 3:
		            dao.compartimentosID();
		            System.out.print("Escolha o compartimento: ");
		            int freezerEscolhido3 = sc.nextInt();
		            dao.consultarFreezerPorId(freezerEscolhido3);
		            dao.removerItem();
		            break;

		        case 5:
		            estoque.exibirMenu2();
		            System.out.print("Escolha a opção: ");
		            int escolha2 = sc.nextInt();
		            sc.nextLine();

		            switch (escolha2) {
		                case 1:
		                    System.out.print("Digite um nome para o compartimento: ");
		                    String nome1 = sc.nextLine();
		                    System.out.println();
		                    dao.adicionarCompartimento(nome1);
		                    System.out.println();
		                    break;

		                case 2:
		                    dao.consultarCompartimentos();
		                    System.out.println();
		                    System.out.print("Digite o nome do compartimento: ");					
		                    String nome2 = sc.nextLine();
		                    dao.removerCompartimento(nome2);
		                    break;

		                case 3:
		                    dao.consultarCompartimentos();
		                    System.out.println(); System.out.println();
		                    break;

		                case 4:
		                    System.out.print("Digite o nome do produto: ");
		                    String nome3 = sc.nextLine();					

		                    dao.compartimentosID();
		                    System.out.println("Digite o id na qual o item vai ser inserido: ");
		                    int id = sc.nextInt();

		                    dao.adicionarItemNoEstoque(nome3, id, 0);	
		                    System.out.println();
		                    break;

		                case 5:
		                    System.out.println("Digite o nome do : ");
		                    String nome4 = sc.nextLine();
		                    dao.removerItemDoEstoque(nome4);
		                    break;
		            }
		            break;
		    }
		} while (escolha != 4);


		System.out.println("Programa encerrado!");

		sc.close();
	}
}