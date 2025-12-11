import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Play Next");
            System.out.println("4. Remove Song");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Artist: ");
                    String artist = sc.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;

                case 2:
                    playlist.displayPlaylist();
                    break;

                case 3:
                    playlist.playNext();
                    break;

                case 4:
                    System.out.print("Remove title: ");
                    String t = sc.nextLine();
                    playlist.removeSong(t);
                    break;

                case 5:
                    running = false;
                    break;
            }
        }
    }
}
