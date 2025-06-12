package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	        System.out.printf("%-15s | %-20s | %-10s%n", "Compartimento", "Item", "Quantidade");
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
	public void consultarFreezerPorId(int freezerId) {
	    Connection conn = DB.getConnection();
	    String sql = """
	        SELECT i.id AS item_id, i.nome AS item_nome, e.quantidade
	        FROM estoque e
	        JOIN itens i ON e.item_id = i.id
	        JOIN freezers f ON e.freezer_id = f.id
	        WHERE f.id = ?;
	    """;

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, freezerId); // passa o id do freezer
	        try (ResultSet rs = stmt.executeQuery()) {
	        	boolean encontrou = false;
	        	
	            while (rs.next()) {
	            	encontrou = true;
	                int id = rs.getInt("item_id");
	                String item = rs.getString("item_nome");
	                int quantidade = rs.getInt("quantidade");

	                System.out.printf("[%d] %s (%d)%n", id, item, quantidade);
	            }
	            if(!encontrou){
	            	throw new DbException("Compartimento com ID " + freezerId + " não encontrado");
	            }
	        }
	    } catch (SQLException e) {
	        throw new DbException(e.getMessage());
	    }
	}

	public void AdicionarItem() throws SQLException{
		Scanner sc = new Scanner (System.in);
		
			System.out.println();
			System.out.print("Digite o número correspondente : ");
			int itemId = sc.nextInt();
			
			System.out.print("Digite a quantidade: ");
			int quantidade = sc.nextInt();				
				
		Connection conn = DB.getConnection();
		String verificaSQL = "SELECT 1 FROM itens WHERE id = ?";
		
		try(PreparedStatement verificaStmt = conn.prepareStatement(verificaSQL)){
			verificaStmt.setInt(1, itemId);
			
			try(ResultSet rs = verificaStmt.executeQuery()){
				if(!rs.next()) {
					throw new DbException("Item com ID " + itemId + " não existe.");
				}
			}
		}
	
		String updateSql ="UPDATE estoque " +
	                "SET quantidade = quantidade + ? "+
	                "WHERE item_id = ?;";
										
		try(PreparedStatement stmt = conn.prepareStatement(updateSql))
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
	
	public void adicionarCompartimento(String nomeFreezer) 
{
	    Connection conn = DB.getConnection();
	    String sql = "INSERT INTO freezers (nome) VALUES (?);";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, nomeFreezer); 
	        
	        int rowAffected = stmt.executeUpdate(); 
	        
	        if (rowAffected > 0) {
	            System.out.println("Compartimento adicionado com sucesso!");
	        } else {
	            System.out.println("Erro ao adicionar compartimento!");
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao adicionar compartimento: " + e.getMessage());
	    }
	}
	public void removerCompartimento(String nomeFreezer) {
	    Connection conn = DB.getConnection();
	    String sql = "DELETE FROM freezers WHERE nome = ?"; 
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, nomeFreezer); 
	        
	        int rowAffected = stmt.executeUpdate(); 
	        
	        if (rowAffected > 0) {
	        	System.out.println();
	            System.out.println("Compartimento removido com sucesso!");
	            System.out.println();
	        } else {
	            System.out.println("Erro ao remover compartimento!");
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao remover compartimento: " + e.getMessage());
	    }
	}
	public void consultarCompartimentos() 
	{
	    Connection conn = DB.getConnection();
	    String sql ="""
				        select nome from freezers;
	    			""";

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        System.out.printf("Lista de compartimentos: ");
	      
	        while (rs.next()) 
	        {
	            String nome = rs.getString("nome");

	            System.out.printf(nome + ", ");
	        }	       
	    }
	    catch (SQLException e) 
	    {
	        throw new DbException(e.getMessage());
	    }
	}
	
	public void adicionarItemNoEstoque(String nomeItem, int freezerId, int quantidade) {
	    Connection conn = DB.getConnection();

	    String insertItemSQL = "INSERT INTO itens (nome) VALUES (?)";
	    String insertEstoqueSQL = "INSERT INTO estoque (freezer_id, item_id, quantidade) VALUES (?, ?, ?)";

	    try (
	        PreparedStatement insertItemStmt = conn.prepareStatement(insertItemSQL, Statement.RETURN_GENERATED_KEYS)
	    ) {
	        insertItemStmt.setString(1, nomeItem);
	        int rows = insertItemStmt.executeUpdate();

	        if (rows > 0) {
	            ResultSet generatedKeys = insertItemStmt.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int itemId = generatedKeys.getInt(1); 

	                
	                try (PreparedStatement insertEstoqueStmt = conn.prepareStatement(insertEstoqueSQL)) {
	                    insertEstoqueStmt.setInt(1, freezerId);
	                    insertEstoqueStmt.setInt(2, itemId);
	                    insertEstoqueStmt.setInt(3, quantidade);

	                    int estoqueRows = insertEstoqueStmt.executeUpdate();
	                    if (estoqueRows > 0) {
	                        System.out.println("Item adicionado ao estoque com sucesso!");
	                    } else {
	                        System.out.println("Erro ao adicionar no estoque.");
	                    }
	                }
	            }
	        } else {
	            System.out.println("Erro ao adicionar item.");
	        }
	    } catch (SQLException e) {
	        throw new DbException("Erro no banco: " + e.getMessage());
	    }
	}
	public void compartimentosID() 
	{
	    Connection conn = DB.getConnection();
	    String sql = """
	                    SELECT id, nome FROM freezers;
	                """;

	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        System.out.println("Lista de compartimentos:");
	      
	        while (rs.next()) 
	        {
	            int id = rs.getInt("id");
	            String nome = rs.getString("nome");

	            System.out.printf("[%d] %s%n", id, nome);
	        }	       
	    }
	    catch (SQLException e) 
	    {
	        throw new DbException(e.getMessage());
	    }
	}
	public void removerItemDoEstoque(String nomeItem) {
	    Connection conn = DB.getConnection();

	    String deleteEstoqueSQL = "DELETE FROM estoque WHERE item_id = (SELECT id FROM itens WHERE nome = ?)";
	    String deleteItemSQL = "DELETE FROM itens WHERE nome = ?";

	    try (
	        PreparedStatement deleteEstoqueStmt = conn.prepareStatement(deleteEstoqueSQL);
	        PreparedStatement deleteItemStmt = conn.prepareStatement(deleteItemSQL)
	    ) {
	       
	        deleteEstoqueStmt.setString(1, nomeItem);
	        deleteEstoqueStmt.executeUpdate();
	        
	        deleteItemStmt.setString(1, nomeItem);
	        int rows = deleteItemStmt.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Item removido com sucesso!");
	        } else {
	            System.out.println("Item não encontrado.");
	        }

	    } catch (SQLException e) {
	        throw new DbException("Erro ao remover item: " + e.getMessage());
	    }
	}

}
					
