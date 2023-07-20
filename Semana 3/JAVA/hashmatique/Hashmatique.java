import java.util.HashMap;

public class Hashmatique {

    public static void main(String[] args){
        HashMap<String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Canción A ",  " Letra A... Lorem ipsum dolor sit amet...");
        tracklist.put("Canción B ",  " Letra B...consectetur adipiscing elit...");
        tracklist.put("Canción C ",  " Letra C...sed do eiusmod tempor incididunt...");
        tracklist.put("Canción D ",  " Letra D... ut labore et dolore magna aliqua...");

        System.out.println(tracklist);
    }
}