public class Songs extends MediaType {
    private String artist;
    private String album;
    private int releaseYear;

    public Songs(String title, String artist, String album, int releaseYear, int duration, String genre) {
        super(title, genre, duration);
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
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

    public boolean matchesFilter(String genre, String artist) {
        return (genre == null || this.genre.equalsIgnoreCase(genre)) && (artist == null || this.artist.equalsIgnoreCase(artist));
    }
    
    public void printSongDetails() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Album: " + album);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Duration: " + songDurationInMinutes());
        System.out.println("Genre: " + genre);
        System.out.println();
    }
}
