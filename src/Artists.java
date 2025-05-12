import java.util.*;

/**
 * The Artists class represents a music artist with a name, genre, and a list of songs.
 * It provides methods to add songs, retrieve songs released after a certain year,
 * and get the artist's name and genre.
 * @author E. Yap
 */
public class Artists {
    private String name;
    private String genre;
    private List<Songs> songs;

    /**
     * Constructor to create an Artists object with a name and genre.
     * @param name The name of the artist.
     * @param genre The genre of the artist.
     */
    public Artists(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.songs = new ArrayList<>();
    }

    /**
     * Gets the name of the artist.
     * @return The name of the artist.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the genre of the artist.
     * @return The genre of the artist.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the list of songs by the artist.
     * @return A list containing all songs associated with the artist.
     */
    public List<Songs> getSongs() {
        return songs;
    }

    /**
     * Adds a song to the artist's list of songs.
     * @param song The song to be added.
     */
    public void addSong(Songs song) {
        songs.add(song);
    }

    /**
     * Retrieves a list of songs released after a specified year.
     * @param year The specified year.
     * @return A list of songs released after the specified year.
     */
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
