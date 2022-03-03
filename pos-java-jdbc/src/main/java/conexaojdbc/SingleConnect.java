package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnect {

	private static String url = "jdbc:postgresql://localhost:5432/posjava";/* só nessa classe usar o static para ser unico */
	private static String password = "";
	private static String user = "postgres";
	private static Connection connection = null; /* Pacote sql */

	static {/* Criar o static direto pois de onde chamar vai conectar */
		conectar();
	}

	public SingleConnect() {
		conectar();
	}

	private static void conectar() {/* Metodo conectar */

		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");/*Carregar o drive do postgresql se for outro tem que pesquisar*/
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				
			System.out.println("Conectou com sucesso");/*Para saber se a conexão esta tudo certo*/
			}
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {/*Para qualquer Problema utilizamos o rolback*/
				e1.printStackTrace();
			}
			e.printStackTrace();/*Aparecer a mensagem no console se der erro*/
		}
		
	}

	public static Connection getConnection() { /* Retornar a nossa conexao dos outros lugares */
		return connection;
	}
}
