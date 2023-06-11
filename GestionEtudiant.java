import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class GestionEtudiant {
    //private Vector<Etudiant> etudiants;
    private static final String url = "jdbc:mysql://localhost:3306/swing_java";
    private static final String username = "root";
    private static final String password = "";

    public GestionEtudiant() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.err.println("Error opening driver connection: " + e.getMessage());
        } 
    }

    public Vector<Etudiant> getEtudiants() {
        Vector<Etudiant> etudiants = new Vector<>();
        
        String query = "SELECT * FROM etudiant";
        
        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {
                
            while (resultSet.next()) {
                int cin = resultSet.getInt("cin");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String adresse = resultSet.getString("adresse");

                Etudiant etud = new Etudiant(cin, nom, prenom,adresse);
                etudiants.add(etud);
            }
            connection.clearWarnings();
            statement.clearWarnings();
            resultSet.clearWarnings();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    public Etudiant getEtudiantByCin(int cinetud) {
        Etudiant etud = null;

        String query = "SELECT * FROM etudiant WHERE cin = ?";
        
        try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cinetud);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int cin = resultSet.getInt("cin");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String adresse = resultSet.getString("adresse");

                    etud = new Etudiant(cin, nom, prenom, adresse);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etud;
    }

    public boolean addEtudiant(Etudiant e) {
        String query = "INSERT INTO etudiant VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, e.getCin());
            statement.setString(2, e.getNom());
            statement.setString(3, e.getPrenom());
            statement.setString(4, e.getAdresse());
            

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean updateEtudiant(Etudiant e) {
        String query = "UPDATE etudiant SET nom = ?, prenom = ?, adresse = ? WHERE cin = ?";
        
        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, e.getNom());
            statement.setString(2, e.getPrenom());
            statement.setString(3, e.getAdresse());
            statement.setInt(4, e.getCin());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public  boolean deleteEtudiant(int cinetud) {
        String query = "DELETE FROM etudiant WHERE cin = ?";

        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cinetud);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
