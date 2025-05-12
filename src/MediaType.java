public class MediaType {
    protected String title;
    protected String genre;
    protected int duration; // in seconds

    public MediaType(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String songDurationInMinutes() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + ":" + String.format("%02d", seconds);
    }
}
