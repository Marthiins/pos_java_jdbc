package dao; // faz operação do banco de dados

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	/* Metodo buscar lista */
	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "select * from userposjava";/* Consulta do banco de dados */

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();/* Objeto result */

		while (resultado.next()) {/* Enquanto for true e estiver dados */
			Userposjava userposjava = new Userposjava();/* Pegar objeto do banco e colocar em uma lista */
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));

			list.add(userposjava);
		}
		return list;

	}

	/* Metodo buscar somente 1 usuario */
	public Userposjava buscar(Long id) throws Exception {
		Userposjava retorno = new Userposjava();

		String sql = "select * from userposjava where id  = " + id;/* Consulta do banco de dados */

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();/* Objeto result */

		while (resultado.next()) {/* retorna apenas um ou nenhum */
			Userposjava userposjava = new Userposjava();/* Pegar objeto do banco e colocar em uma lista */
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}
		return retorno;

	}

}
