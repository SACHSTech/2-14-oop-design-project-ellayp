import java.util.*;

/**
 * The Playlists class represents a music playlist with a title and a list of songs.
 * It provides methods to add songs, retrieve the list of songs, print song details,
 * and calculate the total duration of the playlist.
 * @author E. Yap
 */
public class Playlists {
    private String title;
    private List<Songs> songs;

    /**
     * Constructor to create a Playlists object with a title.
     * @param title The title of the playlist.
     * @param songs The list of songs in the playlist.
     */
    public Playlists(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
    }

    /**
     * Gets the title of the playlist.
     * @return The title of the playlist.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Adds a song to the playlist.
     * @param song The song to be added.
     */
    public void addSong(Songs song) {
        songs.add(song);
    }

    /**
     * Retrieves the list of songs in the playlist.
     * @return A list containing all songs in the playlist.
     */
    public List<Songs> getSongs() {
        return songs;
    }

    /**
     * Prints the details of all songs in the playlist.
     */
    public void printSongs() {
        System.out.println("Playlist:  " + title);
        for (Songs song : songs) {
            System.out.println("- " + song.getTitle() + " by " + song.getArtist());
        }
    }

    /**
     * Calculates the total duration of the playlist in seconds.
     * @return The total duration of the playlist in seconds.
     */
    public int getPlaylistDuration() {
        int totalDuration = 0;
        for (Songs song : songs) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }

    /**
     * Converts the total duration of the playlist from seconds to a string in the format "minutes:seconds".
     * @return The total duration in the format "minutes:seconds".
     */
    public String playlistDurationInMinutes() {
        int totalDuration = getPlaylistDuration();
        return (totalDuration / 60) + ":" + String.format("%02d", totalDuration % 60);
    }
}