public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.addSong("We will rock you");
        playlist.addSong("My heart will go on");
        playlist.addSong("Jingle bells");

        System.out.println("Velkommen til dit hjemmelavede Spotify!");

        boolean run = true;

        while(run){
            System.out.println("""
                Vælg en mulighed:
                1. Add new song
                2. Remove song
                3. Show all songs
                4. Search for song
                5. Edit song
                6. Exit program""");

            int choice = Playlist.scanIntInRange(1,6);

            switch (choice){
                case 1 -> playlist.addSong();
                case 2 -> playlist.removeSong();
                case 3 -> System.out.println(playlist);
                case 4 -> playlist.search();
                case 5 -> playlist.editSong();
                case 6 -> {
                    System.out.println("Exiting...");
                    run = false;
                }
            }
        }
        Playlist.closeScanner();
    }
}
