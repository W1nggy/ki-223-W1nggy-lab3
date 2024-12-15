package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicPerformerExp {

	// Метод для додавання нового виконавця
	public int addMusicPerformer(MusicPerformer musicPerformer) {
		String sql = "INSERT INTO performer (performerName) VALUES (?)";
		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, musicPerformer.getPerformerName());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Метод для отримання виконавця за ID
	public MusicPerformer getMusicPerformerById(int performerId) throws SQLException {
		String sql = "SELECT * FROM performer WHERE performer_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, performerId); // Встановлюємо значення performer_id
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new MusicPerformer(rs.getInt("performer_id"), rs.getString("performerName"));
			}
		}
		return null;
	}

	// Метод для оновлення назви виконавця
	public boolean updateMusicPerformer(int performerId, String newPerformerName) throws SQLException {
		String sql = "UPDATE performer SET performerName = ? WHERE performer_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, newPerformerName);
			stmt.setInt(2, performerId);
			int rowsAffected = stmt.executeUpdate();

			return rowsAffected > 0; // Повертаємо true, якщо оновлення успішне
		}
	}

	// Метод для отримання всіх виконавців
	public List<MusicPerformer> getAllMusicPerformers() throws SQLException {
		List<MusicPerformer> musicPerformers = new ArrayList<>();
		String sql = "SELECT * FROM performer";

		try (Connection conn = DatabaseControl.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				musicPerformers.add(new MusicPerformer(rs.getInt("performer_id"), rs.getString("performerName")));
			}
		}
		return musicPerformers;
	}

	// Метод для видалення виконавця за ID
	public boolean deleteMusicPerformer(int performerId) throws SQLException {
		String sql = "DELETE FROM performer WHERE performer_id = ?";

		try (Connection conn = DatabaseControl.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, performerId);
			int rowsAffected = stmt.executeUpdate();

			return rowsAffected > 0; // Повертаємо true, якщо видалення успішне
		}
	}
}
