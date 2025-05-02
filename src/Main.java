import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Songs> readSongs() throws IOException {
        BufferedReader songscsv = new BufferedReader (new FileReader("src/songs.csv"));
        songscsv.readLine(); // Skip header line
        String line;
        List<Songs> songs = new ArrayList<>();
        while ((line = songscsv.readLine()) != null) {
            String[] fields = line.split(",");
            String title = fields[0];
            String artist = fields[1];
            String album = fields[2];
            int releaseYear = Integer.parseInt(fields[3]);
            int duration = Integer.parseInt(fields[4]);
            String genre = fields[5];
            Songs song = new Songs(title, artist, album, releaseYear, duration, genre);
            songs.add(song);
        }
        songscsv.close();
        return songs;
    }

    public static List<Artists> readArtists() throws IOException {
        BufferedReader artistcsv = new BufferedReader (new FileReader("src/artists.csv"));
        artistcsv.readLine(); // Skip header line
        String line;
        List<Artists> artists = new ArrayList<>();
        while ((line = artistcsv.readLine()) != null) {
            String[] fields = line.split(",");
            String name = fields[0];
            String genre = fields[1];
            Artists artist = new Artists(name, genre);
            artists.add(artist);
        }
        artistcsv.close();
        return artists;
    }

    public static List<Playlists> readPlaylists() throws IOException {
        BufferedReader playlistcsv = new BufferedReader (new FileReader("src/playlists.csv"));
        playlistcsv.readLine(); // Skip header line
        String line;
        List<Playlists> playlists = new ArrayList<>();
        while ((line = playlistcsv.readLine()) != null) {
            String[] fields = line.split(",");
            String title = fields[0];
            Playlists playlist = new Playlists(title);
            playlists.add(playlist);
        }
        playlistcsv.close();
        return playlists;
    }
}