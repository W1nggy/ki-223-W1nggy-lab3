package ua.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicPerformerExp {
    // Insert (Create)
    public void insertMusicPerformer(String performerName) {
        String sql = "INSERT INTO music_performer (performerName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, performerName);
            pstmt.executeUpdate();
            System.out.println("Music performer inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select all (Read)
    public void getAllMusicPerformers() {
        String sql = "SELECT * FROM performer";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("performer_id") +
                        ", Name: " + rs.getString("performerName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateMusicPerformer(int performerId, String newPerformerName) {
        String sql = "UPDATE performer SET performerName = ? WHERE performer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPerformerName);
            pstmt.setInt(2, performerId);
            pstmt.executeUpdate();
            System.out.println("Music performer updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteMusicPerformer(int performerId) {
        String sql = "DELETE FROM performer WHERE performer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, performerId);
            pstmt.executeUpdate();
            System.out.println("Music performer deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
