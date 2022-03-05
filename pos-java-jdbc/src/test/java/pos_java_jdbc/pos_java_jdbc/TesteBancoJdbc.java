package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {

		UserPosDao userPosDao = new UserPosDao();/* Objeto do Dao */
		Userposjava userposjava = new Userposjava();/* Objeto do model */

		userposjava.setId(3L);
		userposjava.setNome("Paulo");
		userposjava.setEmail("Paulo@gmail.com");

		/* Setar os objetos para ter dados */
		userPosDao.salvarBancoDados(userposjava);
	}

	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();/* Sempre chamar o dao */
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {/* Varrer os objetos */
				System.out.println(userposjava);
				System.out.println("-------------------");/* Separar os objetos */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initbuscar() {
		UserPosDao dao = new UserPosDao();/* Sempre chamar o dao */

		try {
			Userposjava userposjava = dao.buscar(5L);

			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() {
		try {
			UserPosDao dao = new UserPosDao();/* Sempre chamar o dao */

			Userposjava objetoBanco = dao.buscar(6L);/* Consultar objeto no banco */

			objetoBanco.setNome("Nome mudado com metodo atualizar");

			dao.atualizar(objetoBanco);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
