import java.sql.*;
public class UserDAO {
    public void createUser(String username, String password, String role) {
        String sql = "INSERT INTO users(username, password, role) VALUES(?,?,?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUsers() {
        String sql = "SELECT * FROM users";
        try {
            Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
