import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends ReadCSV {
    public static void main(String[] args) {
        try {
            List<Songs> songs = ReadCSV.readSongs();
            System.out.println("\nSongs and their Details: ");
            for (Songs song : songs) {
                System.out.println("Title: " + song.getTitle());
                System.out.println("Artist: " + song.getArtist());
                System.out.println("Album: " + song.getAlbum());
                System.out.println("Release Year: " + song.getReleaseYear());
                System.out.println("Duration: " + song.getDurationMinutes());
                System.out.println("Genre: " + song.getGenre());
                System.out.println();
            }

            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to find a song? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Enter the song genre (or click enter to skip): ");
                String genreInput = scanner.nextLine().trim();
                String genre = null;
                if (!genreInput.isEmpty()) {
                    genre = genreInput;
                }
                System.out.println("Enter the artist (or click enter to skip): ");
                String artistInput = scanner.nextLine().trim();
                String artist = null;
                if (!artistInput.isEmpty()) {
                    artist = artistInput;
                }

                List<Songs> filtered = filterSongs(songs, genre, artist);
                if (filtered.isEmpty()) {
                    System.out.println("No songs match your filter. Please try again.");
                } else {
                    System.out.println("\nFiltered Songs: ");
                    for (Songs song : filtered) {
                        System.out.println(song.getTitle() + " by " + song.getArtist());
                    }
                }

                //Scanner scanner = new Scanner(System.in);
                // System.out.println("Enter a genre to filter songs:");
                // String genre = scanner.nextLine();
            } 
            
            System.out.println("\nWould you like to add a song to your collection? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                //Scanner scanner = new Scanner(System.in);
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
                System.out.println("Thanks! Song added.");
                scanner.close();
            }
        }
        catch (IOException e) {
            System.out.println("Error. Please try again. " + e.getMessage());
        }
    }

    public static List<Songs> filterSongs(List<Songs> songs, String genre, String artist) {
        List<Songs> filteredSongs = new ArrayList<>();
        for (Songs song : songs) {
            if ((genre == null || song.getGenre().equalsIgnoreCase(genre)) &&
                (artist == null || song.getArtist().equalsIgnoreCase(artist))) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }
    
}