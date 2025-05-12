/**
 * The Songs class represents a song with its title, artist, album, release year, duration, and genre.
 * It provides methods to get the song's details, check if it matches a filter based on genre and artist,
 * and print the song's details.
 * @author E. Yap
 */
public class Songs extends MediaType {
    private String artist;
    private String album;
    private int releaseYear;

    /**
     * Constructor to create a Songs object with a title, artist, album, release year, duration, and genre.
     * @param title The title of the song.
     * @param artist The artist of the song.
     * @param album The album of the song.
     * @param releaseYear The release year of the song.
     * @param duration The duration of the song in seconds.
     * @param genre The genre of the song.
     */
    public Songs(String title, String artist, String album, int releaseYear, int duration, String genre) {
        super(title, genre, duration);
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
    }

    /**
     * Gets the artist of the song.
     * @return The artist of the song.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the album of the song.
     * @return The album of the song.
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Gets the release year of the song.
     * @return The release year of the song.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Checks if the song matches a filter based on genre and artist.
     * @param genre The genre to filter by.
     * @param artist The artist to filter by.
     * @return True if the song matches the filter, false otherwise.
     */
    public boolean matchesFilter(String genre, String artist) {
        return (genre == null || this.genre.equalsIgnoreCase(genre)) && (artist == null || this.artist.equalsIgnoreCase(artist));
    }
    
    /**
     * Prints the details of the media type.
     * This method overrides the printDetails method in the MediaType class
     * to include additional details specific to the Songs class.
     * It prints the title, artist, album, release year, duration, and genre of the song.
     */
    @Override
    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Duration: " + songDurationInMinutes());
        System.out.println("Genre: " + genre);
        System.out.println();
    }
}
