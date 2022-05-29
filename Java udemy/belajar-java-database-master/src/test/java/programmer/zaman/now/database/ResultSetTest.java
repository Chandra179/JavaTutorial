package programmer.zaman.now.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class ResultSetTest {

	@Test
	void testExecuteQuery() throws SQLException {
		Connection connection = ConnectionUtil.getDataSource().getConnection();
		Statement statement = connection.createStatement();

		String sql = """
				SELECT * FROM student
				""";
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String name = resultSet.getString("name");
			System.out.println(name);
		}

		resultSet.close();
		statement.close();
		connection.close();
	}
}
