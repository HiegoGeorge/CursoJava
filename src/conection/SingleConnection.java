package conection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.management.RuntimeErrorException;

//classe responsavel por fazer conexao com banco de Dados



public class SingleConnection  {
	
	private static String banco = "jdbc:postgresql://localhost:5432/javaweb?autoReconnect=true";
	private static String password = "dev12";
	private static String user = "postgres";
	private static Connection connection =  null;
	
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}


	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco,user,password);
				connection.setAutoCommit(false);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com banco de dados");
		}
	}
	
	public static Connection getConnection() {
		
		return connection; 
		
	}
	

}
