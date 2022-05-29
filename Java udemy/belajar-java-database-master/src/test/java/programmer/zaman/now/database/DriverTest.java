package programmer.zaman.now.database;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DriverTest {

	@Test
	@Disabled
	void testRegister() {

		try {
			Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(mysqlDriver);
		} catch (SQLException exception) {
			Assertions.fail(exception);
		}

	}

}
