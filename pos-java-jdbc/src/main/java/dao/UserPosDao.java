package dao; // faz operação do banco de dados

import java.sql.Connection;

import conexaojdbc.SingleConnect;

public class UserPosDao {
	
private Connection	connection;

/*Construtor*/
public UserPosDao() {
	connection = SingleConnect.getConnection();
}

}
