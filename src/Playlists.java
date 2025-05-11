import java.util.*;

public class Playlists {
    private String title;
    private List<Songs> songs;

    public Playlists(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addSong(Songs song) {
        songs.add(song);
    }

    public int getPlaylistDuration() {
        int totalDuration = 0;
        for (Songs song : songs) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }
}
