package p1;
import java.sql.*;


import com.microsoft.sqlserver.jdbc.SQLServerDriver;
public class DBManager {
	Connection con=null;
	Statement stmt=null;
	public DBManager() throws SQLException {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            String url = "jdbc:sqlserver://127.0.0.1:57354;instanceName=SQLEXPRESS;"
                       + "databaseName=bscs;encrypt=true;trustServerCertificate=true";
            con = DriverManager.getConnection(url, "sa", "123456");
            stmt = con.createStatement();
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            throw e;
        }
    }

    public void insertUpdateDelete(String query) throws SQLException {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Query execution failed: " + e.getMessage());
            throw e;
        }
    }

    // Execute SELECT and print results
    public void select(String query) throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            System.out.println("\n--- Data from Database ---");
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println(); // Move to next line after each row
            }
        } catch (SQLException e) {
            System.out.println("Select query failed: " + e.getMessage());
            throw e;
        }
    }
}	           
