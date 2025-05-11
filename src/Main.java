import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends ReadCSV {
    public static void main(String[] args) {
        try {
            List<Songs> songs = ReadCSV.readSongs();
            System.out.println("Songs and their Details: ");
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
            System.out.println("Would you like to filter songs by genre? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                //Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a genre to filter songs:");
                String genre = scanner.nextLine();

                List<Songs> filteredSongs = new ArrayList<>();
                for (Songs song : songs) {
                    if (song.getGenre().equalsIgnoreCase(genre)) {
                        filteredSongs.add(song);
                    }
                }
                System.out.println();
                System.out.println("Filtered Songs:");
                for (Songs song : filteredSongs) {
                    System.out.println(song.getTitle() + " by " + song.getArtist());
                }
            } 
            
            System.out.println("Would you like to add a song to your collection? (yes/no)");
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
    
}