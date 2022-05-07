public class SelectStatement {
    String selectSql = "SELECT * FROM Users";
    Statement statement = conn.createStatement();
    ResultSet result = statement.executeQuery(selectSql);
    int count = 0;
    while (result.next())
    {
        String name = result.getString(2);
        String pass = result.getString(3);
        String fullname = result.getString("fullname");
        String email = result.getString("email");
        String output = "User #%d: %s - %s - %s - %s";
        System.out.println(String.format(output, ++count, name, pass, fullname, email));
    }
}
