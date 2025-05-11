// import java.util.*;

public class Songs {
    private String title;
    private String artist;
    private String album;
    private int releaseYear;
    private int duration; // in seconds
    private String genre;
    // private List<Songs> songs;
    
    public Songs(String title, String artist, String album, int releaseYear, int duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.genre = genre;
        //this.songs = new ArrayList<>();
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

    // public int getSongCount() {
    //     return songs.size();
    // }

    public String getDurationMinutes() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + ":" + String.format("%02d", seconds);
    }

    // public List<Songs> getSongsByGenre(String genre) {
    //     List<Songs> result = new ArrayList<>();
    //     for (Songs song : songs) {
    //         if (song.getGenre().equalsIgnoreCase(genre)) {
    //             result.add(song);
    //         }
    //     }
    //     return result;
    // }
}
