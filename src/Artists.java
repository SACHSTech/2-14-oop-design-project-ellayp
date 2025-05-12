import java.util.*;

public class Artists {
    private String name;
    private String genre;
    private List<Songs> songs;

    public Artists(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void addSong(Songs song) {
        songs.add(song);
    }

    public List<Songs> getSongsReleasedAfter(int year) {
        List<Songs> releasedSongs = new ArrayList<>();
        for (Songs song : songs) {
            if (song.getReleaseYear() > year) {
                releasedSongs.add(song);
            }
        }
        return releasedSongs;
    }
}
