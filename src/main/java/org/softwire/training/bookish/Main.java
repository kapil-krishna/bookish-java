package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;

import java.sql.*;

import static java.lang.System.getenv;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "library";
        String user = "bookish";
        String password = getenv("dbpass");
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        System.out.println("JDBC method...");

        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);
        Statement stmt = null;
        String query = "select * from Book";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int noOfCopies = rs.getInt("noOfCopies");
                int noAvailable = rs.getInt("noAvailable");
                System.out.println(id + " " + title + " " + noOfCopies + " " + noAvailable);
            }
        } catch (SQLException e ) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);



    }
}
