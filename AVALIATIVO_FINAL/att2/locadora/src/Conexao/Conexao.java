package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String URL ="jdbc:mysql://127.0.0.1:3307/locadoradecarros";
	private static final String USER = "root";
	 private static final String PASSWORD = "root";
	 
	 public static Connection conectar() {
		    try {
		        Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
		        System.out.println("Conexão realizada com sucesso!");
		        return conexao;
		    } catch (SQLException e) {
		        System.out.println("Erro ao conectar ao banco: " + e.getMessage());
		        return null;
		      }
		  }

		  public static void main(String[] args) {
		     conectar();
		  }
		  
	
}