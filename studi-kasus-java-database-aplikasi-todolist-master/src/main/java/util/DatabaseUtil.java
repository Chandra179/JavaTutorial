package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

	private static HikariDataSource hikariDataSource;

	static {
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		config.addDataSourceProperty("portNumber", "5432");
		config.addDataSourceProperty("databaseName", "school");
		config.addDataSourceProperty("user", "alexa");
		config.addDataSourceProperty("password", "admin");

		// pool
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(5);
		config.setIdleTimeout(60_000);
		config.setMaxLifetime(60 * 60 * 1000);

		hikariDataSource = new HikariDataSource(config);
	}

	public static HikariDataSource getDataSource() {
		return hikariDataSource;
	}

}
