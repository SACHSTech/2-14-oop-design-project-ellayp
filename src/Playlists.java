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

    public List<Songs> getSongs() {
        return songs;
    }

    public void printSongs() {
        System.out.println("Playlist:  " + title);
        for (Songs song : songs) {
            System.out.println("- " + song.getTitle() + " by " + song.getArtist());
        }
    }

    public int getPlaylistDuration() {
        int totalDuration = 0;
        for (Songs song : songs) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }

    public String playlistDurationInMinutes() {
        int totalDuration = getPlaylistDuration();
        return (totalDuration / 60) + ":" + String.format("%02d", totalDuration % 60);
    }
}