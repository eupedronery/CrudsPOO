package sobremesa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SobremesaDAOImplement implements SobremesaDAO {
	
	//Metodo de conexao com bando de dados
	
	public final static String hostName = "";
	public final static String dbName = "";
	public final static String user = "";
	public final static String senha = "";
	private Connection con; //variavel que permite a conexao com banco de dados

	
	public SobremesaDAOImplement() {

		try {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");	
		con = DriverManager.getConnection(
				String.format(""
						+ "databaseName=%s;"
						+ "user=%s;"
						+ "password=%s;",
						 hostName, dbName, user, senha));
		} catch(ClassNotFoundException | SQLException e) {
			
		}
	}

        //Metodo DAO de inserção conectado ao botao Salvar
	@Override
	public void criar(Sobremesa ps) {
		
		
		//INSERT INTO que preenche as informacoes da PIZZASALGADA e o ID da PIZZA
		
		String sql = "INSERT INTO SOBREMESA(ID)"
				+ "VALUES("+ ps.getId() +")"
				+ ""
				+ "INSERT INTO SOBREMESA "
				+ "   (ID_SOBREMESA, NOME, VALORTOTAL) "
				+ "VALUES ("+ ps.getId() +", '"+ ps.getNome() +"', "+ ps.getvalorTotal() +")";
			
		try {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "NÃO É PERMITIDO ID REPETIDO", 
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	//Metodo DAO que realiza o pesquisar
	@Override
	public List<Sobremesa> pesquisar(String sabor) {
		
		List<Sobremesa> lista = new ArrayList<>();
		
		//SELECT * FROM QUE que pesquisar com no sabor sem nenhum valor tras lista todos os registros
		
		String sql = ""
				   + " "
				   + " ";
		
		try {
		    PreparedStatement pstmt = con.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		   while(rs.next()) {
			   Sobremesa ps = new Sobremesa();
			   
			   ps.setId(rs.getInt("ID_PIZZA_SAL"));
			   ps.setPreço(rs.getDouble("PREÇO"));
			   lista.add(ps);
			   
		   }
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO NO RETORNO", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
	}
	
	
	//Metodo DAO que apagar os registros incluindo a chave primaria
	public void apagar(Sobremesa ps) {
		
		//DELETE que apgas as pizzas dos tanto da tabela PIZZA quanto da tabela PIZZASALGADA
		
		String sql = "";		   		
		String sql2 = "";
		
		
		try {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();	
			
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.executeUpdate();
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO NA DELETAÇÃO", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	//Metodo DAO que permite na edicao dos valores haver atualizar deles menos do id pois é chave primaria
	public void atualizar(String saborAntigo, Sobremesa ps) {
		
		
		//UPDATE que atualizar as informacoes da pizza salgada menos seu ID por ser a chave primaria
		
		String sql = " ";
	
		try {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "NÃO ALTERAR A CHAVE PRIMARIA", 
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
