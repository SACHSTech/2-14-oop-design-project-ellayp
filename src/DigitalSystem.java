import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DigitalSystem {
    private List<Songs> songs;
    private List<Playlists> playlists;

    public void run() {
        try {
            songs = ReadCSV.readSongs();
            playlists = ReadCSV.readPlaylists();
            displayAllSongs();

            Scanner scanner = new Scanner(System.in);
            songFilter(scanner);
            addSong(scanner);
            createPlaylist(scanner, playlists);
            scanner.close();
        }

        catch (IOException e) {
            System.out.println("Error. Please try again! " + e.getMessage());
        }
    }

    private void displayAllSongs() {
        System.out.println("\nSongs and their Details: ");
        for (Songs song : songs) {
            song.printSongDetails();
        }
    }

    private void songFilter(Scanner scanner) {
        System.out.println("Would you like to find a song? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the song genre (or click enter to skip): ");
            String genre = scanner.nextLine().trim();
            if (genre.isEmpty()) {
                genre = null;
            }
            System.out.println("Enter the artist (or click enter to skip): ");
            String artist = scanner.nextLine().trim();
            if (artist.isEmpty()) {
                artist = null;
            }

            List<Songs> filtered = filterSongs(genre, artist);
            if (filtered.isEmpty()) {
                System.out.println("No songs match your filter. Please try again!");
            } else {
                System.out.println("\nFiltered Songs: ");
                for (Songs song : filtered) {
                    System.out.println(song.getTitle() + " by " + song.getArtist());
                }
            }
        } 
    }

    private List<Songs> filterSongs(String genre, String artist) {
        List<Songs> filteredSongs = new ArrayList<>();
        for (Songs song : songs) {
            if (song.matchesFilter(genre, artist)) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

    private void addSong(Scanner scanner) throws IOException {
        System.out.println("\nWould you like to add a song to your collection? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the title of the song:");
            String title = scanner.nextLine();
            System.out.println("Enter the artist of the song:");
            String artist = scanner.nextLine();
            System.out.println("Enter the album of the song:");
            String album = scanner.nextLine();
            System.out.println("Enter the release year of the song:");
            int releaseYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the duration of the song in seconds:");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the genre of the song:");
            String genre = scanner.nextLine();

            Songs newSong = new Songs(title, artist, album, releaseYear, duration, genre);
            songs.add(newSong);
            ReadCSV.appendSong(newSong);
            System.out.println("Song added successfully!");

        }
    }

    private void createPlaylist(Scanner scanner, List<Playlists> playlists) throws IOException {
        System.out.println("\nWould you like to create a playlist? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the title of the playlist:");
            String playlistName = scanner.nextLine();
            Playlists playlist = new Playlists(playlistName);

            boolean addingSongs = true;
            while (addingSongs) {
                System.out.println("Enter a song title to add (or type 'done' to finish):");
                String songTitle = scanner.nextLine();
                if (songTitle.equalsIgnoreCase("done")) {
                    addingSongs = false;
                } else {
                    boolean found = false;
                    for (Songs song : songs) {
                        if (song.getTitle().equalsIgnoreCase(songTitle)) {
                            playlist.addSong(song);
                            System.out.println("Added \"" + song.getTitle() + "\" to playlist.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Song not found. Please try again.");
                    }
                }
            }
            if (playlist.getSongs().isEmpty()) {
                System.out.println("No songs added to the playlist. The playlist was not saved.");
            } else {
                ReadCSV.appendPlaylist(playlist);
                System.out.println("Playlist \"" + playlist.getTitle() + "\" created with " + playlist.getSongs().size() + " songs.");
                System.out.println("Total Duration: " + playlist.getPlaylistDuration() / 60 + " minutes");
                playlist.printSongs();
            }
        }
    }
}
