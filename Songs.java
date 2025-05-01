public class Songs {
    private String title;
    private String artist;
    private String album;
    private int releaseYear;
    private int duration; // in seconds

    public Songs(String title, String artist, String album, int releaseYear, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
        this.duration = duration;
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

    public int getReleaseYear () {
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }
}
