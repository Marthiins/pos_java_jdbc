package dao; // faz operação do banco de dados

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaojdbc.SingleConnect;
import model.Userposjava;

public class UserPosDao {

	private Connection connection;

	/* Construtor */
	public UserPosDao() {
		connection = SingleConnect.getConnection();
	}

	public void salvarBancoDados(Userposjava userposjava) {/* UserposJava nossa classe userposjava nome do banco */
		try {
			String sql = "insert into userposjava(id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);/* PreparedStatement é o insert */
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute(); /* Vai executar no banco de dados */
			connection.commit();/* Vai salvar no banco de dados */
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
