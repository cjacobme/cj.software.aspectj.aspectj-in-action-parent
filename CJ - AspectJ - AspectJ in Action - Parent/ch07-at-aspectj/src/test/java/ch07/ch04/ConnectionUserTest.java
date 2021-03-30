package ch07.ch04;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ConnectionUserTest
{
	@Mock
	private Connection connection;

	@Before
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void scenario1() throws SQLException
	{
		ConnectionUser cu = new ConnectionUser(this.connection);
		cu.prepare("select something from somewhere");
	}
}
