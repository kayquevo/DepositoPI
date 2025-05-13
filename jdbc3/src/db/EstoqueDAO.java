package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EstoqueDAO {

	public void consultarTodosItens() 
	{
	    Connection conn = DB.getConnection();
	    String sql ="""
				        SELECT f.nome AS freezer_nome, i.nome AS item_nome, e.quantidade
				        FROM estoque e
				        JOIN itens i ON e.item_id = i.id
				        JOIN freezers f ON e.freezer_id = f.id
	    			""";

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        System.out.printf("%-15s | %-20s | %-10s%n", "Freezer", "Item", "Quantidade");
	        System.out.println("-----------------------------------------------------");

	        while (rs.next()) 
	        {
	            String freezer = rs.getString("freezer_nome");
	            String item = rs.getString("item_nome");
	            int quantidade = rs.getInt("quantidade");

	            System.out.printf("%-15s | %-20s | %-10d%n", freezer, item, quantidade);
	        }	       
	    }
	    catch (SQLException e) 
	    {
	        throw new DbException(e.getMessage());
	    }
	}
	public void consultarFreezer1() 
	{
	    Connection conn = DB.getConnection();
	    String sql ="""
				        SELECT i.id AS item_id, i.nome AS item_nome, e.quantidade
						FROM estoque e
						JOIN itens i ON e.item_id = i.id
						JOIN freezers f ON e.freezer_id = f.id
						WHERE f.nome = 'Freezer1';
	    			""";

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {



	        while (rs.next()) 
	        {
	        	int id = rs.getInt("item_id");
	            String item = rs.getString("item_nome");
	            int quantidade = rs.getInt("quantidade");

	            System.out.printf("[%d] %s (%d)%n", id, item, quantidade);
	        }	       
	    }
	    catch (SQLException e) 
	    {
	        throw new DbException(e.getMessage());
	    }
	}
	public void consultarFreezer2() 
	{
	    Connection conn = DB.getConnection();
	    String sql ="""
				        SELECT i.id AS item_id, i.nome AS item_nome, e.quantidade
						FROM estoque e
						JOIN itens i ON e.item_id = i.id
						JOIN freezers f ON e.freezer_id = f.id
						WHERE f.nome = 'Freezer2';
	    			""";

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {



	        while (rs.next()) 
	        {
	        	int id = rs.getInt("item_id");
	            String item = rs.getString("item_nome");
	            int quantidade = rs.getInt("quantidade");

	            System.out.printf("[%d] %s (%d)%n", id, item, quantidade);
	        }	       
	    }
	    catch (SQLException e) 
	    {
	        throw new DbException(e.getMessage());
	    }
	}
	public void consultarFreezer3() 
	{
	    Connection conn = DB.getConnection();
	    String sql ="""
				        SELECT i.id AS item_id, i.nome AS item_nome, e.quantidade
						FROM estoque e
						JOIN itens i ON e.item_id = i.id
						JOIN freezers f ON e.freezer_id = f.id
						WHERE f.nome = 'Freezer3';
	    			""";

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {



	        while (rs.next()) 
	        {
	        	int id = rs.getInt("item_id");
	            String item = rs.getString("item_nome");
	            int quantidade = rs.getInt("quantidade");

	            System.out.printf("[%d] %s (%d)%n", id, item, quantidade);
	        }	       
	    }
	    catch (SQLException e) 
	    {
	        throw new DbException(e.getMessage());
	    }
	}
	public void consultarFreezer4() 
	{
	    Connection conn = DB.getConnection();
	    String sql ="""
				        SELECT i.id AS item_id, i.nome AS item_nome, e.quantidade
						FROM estoque e
						JOIN itens i ON e.item_id = i.id
						JOIN freezers f ON e.freezer_id = f.id
						WHERE f.nome = 'Freezer4';
	    			""";

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {



	        while (rs.next()) 
	        {
	        	int id = rs.getInt("item_id");
	            String item = rs.getString("item_nome");
	            int quantidade = rs.getInt("quantidade");

	            System.out.printf("[%d] %s (%d)%n", id, item, quantidade);
	        }	       
	    }
	    catch (SQLException e) 
	    {
	        throw new DbException(e.getMessage());
	    }
	}
	
	public void AdicionarItem()
	{
		Scanner sc = new Scanner (System.in);
		
			System.out.println();
			System.out.print("Digite o número correspondente : ");
			int itemId = sc.nextInt();
			
			System.out.print("Digite a quantidade: ");
			int quantidade = sc.nextInt();				
				
		Connection conn = DB.getConnection();
		String sql ="UPDATE estoque " +
	                "SET quantidade = quantidade + ? "+
	                "WHERE item_id = ?;";
					
					
		try(PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setInt(1, quantidade);
			stmt.setInt(2, itemId);
			
			int rowAffected = stmt.executeUpdate();
			
			if(rowAffected > 0)
			{
				System.out.println();
				System.out.println("Item adicionado com exito!");
				System.out.println();
			}
			else
			{
				System.out.println("Item inválido!");
			}
			}
			catch(SQLException e)
			{
				System.out.println("Erro na atualização" + e.getMessage());
			}
		
		}
	public void removerItem()
	{
		Scanner sc = new Scanner (System.in);
			System.out.println();
			System.out.print("Digite o número correspondente : ");
			int itemId = sc.nextInt();
			
			System.out.print("Digite a quantidade: ");
			int quantidade = sc.nextInt();				
				
		Connection conn = DB.getConnection();
		String sql ="UPDATE estoque " +
	                "SET quantidade = quantidade - ? "+
	                "WHERE item_id = ?;";
					
					
		try(PreparedStatement stmt = conn.prepareStatement(sql))
		{
			stmt.setInt(1, quantidade);
			stmt.setInt(2, itemId);
			
			int rowAffected = stmt.executeUpdate();
			
			if(rowAffected > 0)
			{
				System.out.println();
				System.out.println("Item removido com exito!");
				System.out.println();
			}
			else
			{
				System.out.println("Item inválido!");
			}
			}
			catch(SQLException e)
			{
				System.out.println("Erro na atualização" + e.getMessage());
			}
		
		}
}
					
					
	
