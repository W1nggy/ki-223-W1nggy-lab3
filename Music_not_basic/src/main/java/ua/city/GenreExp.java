package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreExp {
    // Insert (Create)
    public void insertGenre(String genreName) {
        String sql = "INSERT INTO genre (genreName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, genreName);
            pstmt.executeUpdate();
            System.out.println("Genre inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllGenres() {
        String sql = "SELECT * FROM genre";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("genre_id") +
                        ", Name: " + rs.getString("genreName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateGenre(int genreId, String newGenreName) {
        String sql = "UPDATE genre SET genreName = ? WHERE genre_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newGenreName);
            pstmt.setInt(2, genreId);
            pstmt.executeUpdate();
            System.out.println("Genre updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteGenre(int genreId) {
        String sql = "DELETE FROM genre WHERE genre_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, genreId);
            pstmt.executeUpdate();
            System.out.println("Genre deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}