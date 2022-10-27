package programmer.zaman.now.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolTest {

	@Test
	void testHikariCP() {
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		config.addDataSourceProperty("portNumber", "5432");
		config.addDataSourceProperty("databaseName", "student");
		config.addDataSourceProperty("user", "alexa");
		config.addDataSourceProperty("password", "admin");

		config.setMaximumPoolSize(10);
		config.setMinimumIdle(5);
		config.setIdleTimeout(60_000);
		config.setMaxLifetime(10 * 60_000);

		try {
			HikariDataSource dataSource = new HikariDataSource(config);
			Connection connection = dataSource.getConnection();
			connection.close();
			dataSource.close();
		} catch (SQLException exception) {
			Assertions.fail(exception);
		}
	}

	@Test
	void testUtil() throws SQLException {
		Connection connection = ConnectionUtil.getDataSource().getConnection();
	}
}
