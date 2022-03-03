package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnect;
import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {

		UserPosDao userPosDao = new UserPosDao();/* Objeto do Dao */
		Userposjava userposjava = new Userposjava();/* Objeto do model */

		userposjava.setId(6L);
		userposjava.setNome("Paulo");
		userposjava.setEmail("Paulo@gmail.com");
		
		/* Setar os objetos para ter dados */
		userPosDao.salvarBancoDados(userposjava);
	}
}
