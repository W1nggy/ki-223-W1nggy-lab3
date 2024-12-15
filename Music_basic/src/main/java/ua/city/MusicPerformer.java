package ua.city;

public class MusicPerformer {
    private int performerId;
    private String performerName;

    // Конструктор за замовчуванням
    public MusicPerformer() {
    }

    // Конструктор з параметрами
    public MusicPerformer(int performerId, String performerName) {
        this.performerId = performerId;
        this.performerName = performerName;
    }

    // Геттери та сеттери
    public int getPerformerId() {
        return performerId;
    }

    public void setPerformerId(int performerId) {
        this.performerId = performerId;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }
}
