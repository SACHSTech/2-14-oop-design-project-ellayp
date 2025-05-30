import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ReadCSV class provides methods to read and write songs and playlists from/to CSV files.
 * It includes methods to read songs, artists, and playlists from CSV files,
 * as well as methods to append new songs and playlists to the respective CSV files.
 * @author E. Yap
 */
public class ReadCSV {
    /**
     * Reads songs from the CSV file and returns a list of Songs objects.
     * @return A list of Songs objects.
     * @throws IOException If an error occurs while reading the file.
     */
    public static List<Songs> readSongs() throws IOException {
        BufferedReader songscsv = new BufferedReader (new FileReader("src/songs.csv"));
        songscsv.readLine(); // Skip header line
        String line;
        List<Songs> songs = new ArrayList<>();
        while ((line = songscsv.readLine()) != null) {
            String[] fields = line.split(",");
            for (int i = 0; i < fields.length; i++) {
                fields[i] = fields[i].trim(); // Remove quotes
            }

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

    /**
     * Reads artists from the CSV file and returns a list of Artists objects.
     * @return A list of Artists objects.
     * @throws IOException If an error occurs while reading the file.
     */
    public static List<Artists> readArtists() throws IOException {
        BufferedReader artistcsv = new BufferedReader (new FileReader("src/songs.csv"));
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

    /**
     * Reads playlists from the CSV file and returns a list of Playlists objects.
     * @return A list of Playlists objects.
     * @throws IOException If an error occurs while reading the file.
     */
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

    /**
     * Appends a new song to the CSV file.
     * @param song The song to be appended.
     * @throws IOException If an error occurs while writing to the file.
     */
    public static void appendSong(Songs song) throws IOException {
        // Append the song to the CSV file
        PrintWriter writer = new PrintWriter(new FileWriter("src/songs.csv", true));
        writer.println(song.getTitle() + "," + song.getArtist() + "," + song.getAlbum() + "," + song.getReleaseYear() + "," + song.getDuration() + "," + song.getGenre());
        writer.close();
    }

    /**
     * Appends a new playlist to the CSV file.
     * @param playlist The playlist to be appended.
     * @throws IOException If an error occurs while writing to the file.
     */
    public static void appendPlaylist(Playlists playlist) throws IOException {
        // Append the playlist to the CSV file
        PrintWriter writer = new PrintWriter(new FileWriter("src/playlists.csv", true));
        StringBuilder line = new StringBuilder(playlist.getTitle());
        for (Songs song : playlist.getSongs()) {
            line.append(",").append(song.getTitle());
        }
        writer.println(line.toString());
        writer.close();
    }
}