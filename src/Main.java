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
            System.out.println("Enter a genre to filter songs:");
            String genre = scanner.nextLine();

            List<Songs> filteredSongs = new ArrayList<>();
            for (Songs song : songs) {
                if (song.getGenre().equalsIgnoreCase(genre)) {
                    filteredSongs.add(song);
                }
            }
            scanner.close();
            System.out.println();
            System.out.println("Filtered Songs:");
            for (Songs song : filteredSongs) {
                System.out.println(song.getTitle() + " by " + song.getArtist());
            }
        }
        catch (IOException e) {
            System.out.println("Error. Please try again. " + e.getMessage());
        }
        
    }
}
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.*;

// public class Main {
//     public static List<Songs> readSongs() throws IOException {
//         BufferedReader songscsv = new BufferedReader(new FileReader("src/songs.csv"));
//         songscsv.readLine(); // Skip header line
//         String line;
//         List<Songs> songs = new ArrayList<>();
//         while ((line = songscsv.readLine()) != null) {
//             String[] fields = line.split(",");
//             String title = fields[0];
//             String artist = fields[1];
//             String album = fields[2];
//             int releaseYear = Integer.parseInt(fields[3]);
//             int duration = Integer.parseInt(fields[4]);
//             String genre = fields[5];

//             Songs song = new Songs(title, artist, album, releaseYear, duration, genre);
//             songs.add(song);
//         }
//         songscsv.close();
//         return songs;
//     }



//     public static void main(String[] args) throws IOException {
//         List<Songs> songs = readSongs();
//         System.out.println("Number of songs: " + songs.size());
//     }
// }