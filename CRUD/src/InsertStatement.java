public class InsertStatement {
    String insertSql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

    PreparedStatement statement = conn.prepareStatement(insertSql);
                statement.setString(1, "bill");
                statement.setString(2, "secretpass");
                statement.setString(3, "Bill Gates");
                statement.setString(4, "bill.gates@microsoft.com");
    Integer rowsInserted = statement.executeUpdate();
    if (rowsInserted > 0) {
        System.out.println("A new user was inserted successfully!");
    }
}
