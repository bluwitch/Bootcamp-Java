import java.util.HashMap;

public class Hashmatique {

    public static void main(String[] args){
        HashMap<String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Track A",  "Lyrics: ... Lorem ipsum dolor sit amet...");
        tracklist.put("Track B",  "Lyrics: ...consectetur adipiscing elit...");
        tracklist.put("Track C",  "Lyrics: ...sed do eiusmod tempor incididunt...");
        tracklist.put("Track D",  "Lyrics: ... ut labore et dolore magna aliqua...");

        System.out.println(tracklist);
    }
}