package programmer.zaman.now.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class TransactionTest {

	@Test
	void testCommit() throws SQLException {
		Connection connection = ConnectionUtil.getDataSource().getConnection();
		connection.setAutoCommit(false);

		String sql = "INSERT INTO student(name) VALUES (?)";
		for (int i = 0; i < 10; i++) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "hi" + i);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}

		connection.commit();
		connection.close();
	}

	@Test
	void testRollback() throws SQLException {
		Connection connection = ConnectionUtil.getDataSource().getConnection();
		connection.setAutoCommit(false);

		String sql = "INSERT INTO student(name) VALUES (?)";
		for (int i = 0; i < 10; i++) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "testtt" + i);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}

		connection.rollback();
		connection.close();
	}
}
