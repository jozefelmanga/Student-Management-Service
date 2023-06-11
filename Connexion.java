// import java.sql.*;

// public class Connexion {

//     public Connexion() {
       
//     }
//    public void connect(){
//     String url = "jdbc:mysql://localhost/swing_java";
//     try {
//         Class.forName("com.mysql.jdbc.Driver");
//         Connection CN = DriverManager.getConnection(url, "root", "");
//         Statement st = CN.createStatement();
//         // ResultSet rs = st.executeQuery("select * from Etudiant");
//         // while (rs.next()) {
//         //     System.out.println(rs.getString(1));
//         // }
//         System.out.println("connected");
//     } catch (ClassNotFoundException e) {
//         System.err.println("Error opening driver connection: " + e.getMessage());
//     } catch (SQLException e) {
//         System.err.println("Error opening SQL connection: " + e.getMessage());
//     }
    
// } 

// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String url = "jdbc:mysql://localhost:3306/swing_java";
    private static final String username = "root";
    private static final String password = "";

    public static void connectToDatabase() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Use the connection for executing SQL queries or other database operations
            System.out.println("Connected to the database.");

            // Perform database operations here

            System.out.println("Database operations completed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

