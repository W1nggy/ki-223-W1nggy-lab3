package ua.city;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandControl {
    private GenreExp genreExp = new GenreExp();
    private MusicPerformerExp musicPerformerExp = new MusicPerformerExp();
    private SongExp songExp = new SongExp();

    public void executeCommand(String command) {
        if (command.startsWith("insert genre")) {
            // Додати жанр
            Pattern pattern = Pattern.compile("name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String name = matcher.group(1);
                genreExp.insertGenre(name);
                System.out.println("Inserted genre successfully.");
            } else {
                System.out.println("Invalid insert genre command format.");
            }
        } else if (command.startsWith("update genre")) {
            // Оновити жанр
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                genreExp.updateGenre(id, newName);
                System.out.println("Updated genre successfully.");
            } else {
                System.out.println("Invalid update genre command format.");
            }
        } else if (command.startsWith("delete genre")) {
            // Видалити жанр
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                genreExp.deleteGenre(id);
                System.out.println("Deleted genre successfully.");
            } else {
                System.out.println("Invalid delete genre command format.");
            }
        } else if (command.startsWith("read genre")) {
            // Зчитати всі жанри
            genreExp.getAllGenres();

        } else if (command.startsWith("insert performer")) {
            // Додати виконавця
            Pattern pattern = Pattern.compile("name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String name = matcher.group(1);
                musicPerformerExp.insertMusicPerformer(name);
                System.out.println("Inserted music performer successfully.");
            } else {
                System.out.println("Invalid insert performer command format.");
            }
        } else if (command.startsWith("update performer")) {
            // Оновити виконавця
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                musicPerformerExp.updateMusicPerformer(id, newName);
                System.out.println("Updated music performer successfully.");
            } else {
                System.out.println("Invalid update performer command format.");
            }
        } else if (command.startsWith("delete performer")) {
            // Видалити виконавця
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                musicPerformerExp.deleteMusicPerformer(id);
                System.out.println("Deleted music performer successfully.");
            } else {
                System.out.println("Invalid delete performer command format.");
            }
        } else if (command.startsWith("read performer")) {
            // Зчитати всіх виконавців
            musicPerformerExp.getAllMusicPerformers();

        } else if (command.startsWith("insert song")) {
            // Додати пісню
            Pattern pattern = Pattern.compile("name='(.+?)', duration='(\\d{2}:\\d{2}:\\d{2})'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String name = matcher.group(1);
                String duration = matcher.group(2);
                songExp.insertSong(name, duration);
                System.out.println("Inserted song successfully.");
            } else {
                System.out.println("Invalid insert song command format.");
            }
        } else if (command.startsWith("update song")) {
            // Оновити пісню
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'(?:, duration='(\\d{2}:\\d{2}:\\d{2})')?");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                String newDuration = matcher.group(3); // Може бути null
                if (newDuration != null) {
                    songExp.updateSong(id, newName, newDuration);
                } else {
                    songExp.updateSongName(id, newName);
                }
                System.out.println("Updated song successfully.");
            } else {
                System.out.println("Invalid update song command format.");
            }
        } else if (command.startsWith("delete song")) {
            // Видалити пісню
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                songExp.deleteSong(id);
                System.out.println("Deleted song successfully.");
            } else {
                System.out.println("Invalid delete song command format.");
            }
        } else if (command.startsWith("read song")) {
            // Зчитати всі пісні
            songExp.getAllSongs();

        } else {
            System.out.println("Unknown command. Please try again.");
        }
    }
}
