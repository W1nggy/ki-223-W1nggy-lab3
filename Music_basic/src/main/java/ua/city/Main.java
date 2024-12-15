package ua.city;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Створення об'єктів DAO
        GenreExp genreExp = new GenreExp();
        MusicPerformerExp musicPerformerExp = new MusicPerformerExp();
        SongExp songExp = new SongExp();

        // Приклад додавання жанру
        Genre genre = new Genre();
        genre.setGenreName("Rock-n-Roll");
        int genreId = genreExp.addGenre(genre);
        genre.setGenreId(genreId);

        if (genreId > 0) {
            System.out.println("Жанр додано: " + genre);
        } else {
            System.out.println("Помилка: не вдалося додати жанр.");
        }

        // Приклад додавання музичного виконавця
        MusicPerformer musicPerformer = new MusicPerformer();
        musicPerformer.setPerformerName("Chuck Berry");
        int performerId = musicPerformerExp.addMusicPerformer(musicPerformer);
        musicPerformer.setPerformerId(performerId);

        if (performerId > 0) {
            System.out.println("Музичного виконавця додано: " + musicPerformer);
        } else {
            System.out.println("Помилка: не вдалося додати музичного виконавця.");
        }

        // Приклад додавання пісні
        Song song = new Song();
        song.setSongName("Johnny B. Goode");
        song.setSongDuration("00:02:43");
        int songId = songExp.addSong(song);
        song.setSongId(songId);

        if (songId > 0) {
            System.out.println("Пісню додано: " + song);
        } else {
            System.out.println("Помилка: не вдалося додати пісню.");
        }

        // Виведення всіх жанрів
        System.out.println("\nСписок жанрів:");
        List<Genre> genres = genreExp.getAllGenres();
        for (Genre g : genres) {
            System.out.println("ID: " + g.getGenreId() + ", Назва: " + g.getGenreName());
        }

        // Виведення всіх музичних виконавців
        System.out.println("\nСписок музичних виконавців:");
        List<MusicPerformer> musicPerformers = musicPerformerExp.getAllMusicPerformers();
        for (MusicPerformer p : musicPerformers) {
            System.out.println("ID: " + p.getPerformerId() + ", Назва: " + p.getPerformerName());
        }

        // Виведення всіх пісень
        System.out.println("\nСписок пісень:");
        List<Song> songs = songExp.getAllSongs();
        for (Song s : songs) {
            System.out.println("ID: " + s.getSongId() + ", Назва: " + s.getSongName() + ", Тривалість: " + s.getSongDuration());
        }
    }
}
