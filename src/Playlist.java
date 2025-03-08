import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private static final Scanner scanner = new Scanner(System.in);

    private final ArrayList<Song> playlist;

    public Playlist(){
        this.playlist=new ArrayList<>();
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        int count = 1;
        for(Song item: playlist){
            str.append(count).append(". ").append(item).append("\n");
            count++;
        }
        return str.toString();
    }

    public void addSong(){
        System.out.println("Enter song title:");
        scanner.nextLine(); // Consume leftover newline
        String title = scanner.nextLine();
        playlist.add(new Song(title));
    }

    public void addSong(String title){
        playlist.add(new Song(title));
    }

    public void removeSong(){ //removes all instances
        System.out.println("Enter song title:");
        scanner.nextLine(); // Consume leftover newline
        String title = scanner.nextLine();
        boolean removed = playlist.removeIf(song -> song.getTitle().equalsIgnoreCase(title));

        if(!removed){
            System.out.println("Song not found...");
        }
    }

    public Playlist searchResult (String search){
        Playlist result = new Playlist();

//        boolean found = false;
//
//        for(int i = 0; i< playlist.size(); i++){ //iterate through Songs
//            String title = playlist.get(i).getTitle(); //get song title
//            if(title.length()>=search.length()){ //only check Song if no search is not longer than title
//                for(int j = 0; j<title.length()-(search.length()-1); j++){ //iterate through title characters
//                    String sub = title.substring(j,j+search.length());
//                    if(sub.equals(search)){ //if search is contained in title, print title
//                        result.playlist.add(playlist.get(i));
//                        found=true;
//                    }
//                }
//            }
//        }
//
//        return (found) ? result: null;

        for(Song item: playlist){
            if(item.getTitle().toLowerCase().contains(search.toLowerCase())){
                result.playlist.add(item);
            }
        }

        return result;
    }

    public void search(){
        System.out.println("Enter search:");
        scanner.nextLine(); // Consume leftover newline
        String search = scanner.nextLine();
        Playlist result = searchResult(search);
        if(result.playlist.isEmpty()){
            System.out.println("Song not found...");
        }else{
            System.out.println(result);
        }
        System.out.println();
    }

    public Song pickSong(int i){
        return playlist.get(i-1);
    }

    public void editSong(){
        System.out.println("Enter search:");
        scanner.nextLine(); // Consume leftover newline
        String search = scanner.nextLine();
        Playlist result = searchResult(search);
        if(result==null){
            System.out.println("Song not found...");
        }else{
            System.out.println(result);
            System.out.println("Choose song to edit, by entering its number");
            int choice = scanIntInRange(1,result.playlist.size());
            Song song = result.pickSong(choice);
            System.out.println("Editing: "+song);

            System.out.println("Enter new title:");
            scanner.nextLine(); // Consume leftover newline
            String title = scanner.nextLine();
            song.setTitle(title);
            System.out.println("The songs title is now: "+song);
        }
        System.out.println();
    }

    public static int scanIntInRange (int min, int max){
        int result;
        while(true){
            if(scanner.hasNextInt()){
                result=scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
                if(result>=min && result<=max) break;
            }else{
                scanner.nextLine(); // Clear invalid input
            }
            System.out.println("Invalid input. Input number between"+min+" and "+max+".");
        }
        return result;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
