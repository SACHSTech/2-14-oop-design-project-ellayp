// import java.util.*;

public class Songs {
    private String title;
    private String artist;
    private String album;
    private int releaseYear;
    private int duration; // in seconds
    private String genre;
    
    public Songs(String title, String artist, String album, int releaseYear, int duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getDurationMinutes() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + ":" + String.format("%02d", seconds);
    }
}
