/**
 * The MediaType class represents a media type with a title, genre, and duration.
 * It provides methods to get the title, genre, and duration, as well as a method
 * to print the details of the media type.
 * @author E. Yap
 */
public class MediaType {
    private String title;
    private String genre;
    private int duration; // in seconds

    /**
     * Constructor to create a MediaType object with a title, genre, and duration.
     * @param title The title of the media type.
     * @param genre The genre of the media type.
     * @param duration The duration of the media type in seconds.
     */
    public MediaType(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    /**
     * Gets the title of the media type.
     * @return The title of the media type.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Gets the genre of the media type.
     * @return The genre of the media type.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the duration of the media type in seconds.
     * @return The duration of the media type in seconds.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Prints the details of the media type.
     */
    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + songDurationInMinutes());
    }

    /**
     * Converts the duration from seconds to a string in the format "minutes:seconds".
     * @return The duration in the format "minutes:seconds".
     */
    public String songDurationInMinutes() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + ":" + String.format("%02d", seconds);
    }
}