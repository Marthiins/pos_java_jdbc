package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnect;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		
		SingleConnect.getConnection();
	}
}
