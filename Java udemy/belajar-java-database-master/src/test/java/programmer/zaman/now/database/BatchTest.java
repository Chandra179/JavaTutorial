package programmer.zaman.now.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class BatchTest {

	@Test
	void testStatement() throws SQLException {
		Connection connection = ConnectionUtil.getDataSource().getConnection();
		Statement statement = connection.createStatement();

		String sql = "INSERT INTO student(name) VALUES ('test')";

		for (int i = 0; i < 10; i++) {
			statement.addBatch(sql);
		}

		statement.executeBatch();

		statement.close();
		connection.close();
	}

	@Test
	void testPreparedStatement() throws SQLException {
		Connection connection = ConnectionUtil.getDataSource().getConnection();
		String sql = "INSERT INTO student(name) VALUES (?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		for (int i = 0; i < 10; i++) {
			preparedStatement.clearParameters();
			preparedStatement.setString(1, "name" + i);
			preparedStatement.addBatch();
		}

		preparedStatement.executeBatch();

		preparedStatement.close();
		connection.close();
	}
}
