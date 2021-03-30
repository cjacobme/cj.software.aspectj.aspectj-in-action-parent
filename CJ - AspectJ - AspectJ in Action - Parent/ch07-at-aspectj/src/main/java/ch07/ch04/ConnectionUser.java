package ch07.ch04;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUser
{
	private Connection connection;

	public ConnectionUser(Connection connection)
	{
		this.connection = connection;
	}

	public void prepare(String statement) throws SQLException
	{
		this.connection.prepareStatement(statement);
	}
}
