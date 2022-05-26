package programmer.zaman.now.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ConnectionTest {

	@Test
	void testConnectionPostgres() {
		String url = "jdbc:postgresql://localhost/school";
		Properties props = new Properties();
		props.setProperty("user", "alexa");
		props.setProperty("password", "admin");
		try {
			Connection conn = DriverManager.getConnection(url, props);
			System.out.println(conn.getClass());
			System.out.println(conn.getClientInfo());
			System.out.println(conn.getMetaData());
			System.out.println("Sukses konek ke database");
			conn.close();
		} catch (SQLException exception) {
			Assertions.fail(exception);
		}
	}

//	@BeforeAll
//	static void beforeAll() {
//		try {
//			Driver mysqlDriver = new com.postgres.cj.jdbc.Driver();
//			DriverManager.registerDriver(mysqlDriver);
//		} catch (SQLException exception) {
//			exception.printStackTrace();
//		}
//	}

	@Test
	@Disabled
	void testConnection() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
		String username = "root";
		String password = "";

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

			System.out.println("Sukses konek ke database");
		} catch (SQLException exception) {
			Assertions.fail(exception);
		}
	}

	@Test
	@Disabled
	void testConnectionClose() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
		String username = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			System.out.println("Sukses konek ke database");
		} catch (SQLException exception) {
			Assertions.fail(exception);
		}
	}
}
