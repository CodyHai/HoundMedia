package tagMedia;
import java.util.*;


public class Usr {
    String username;
    ArrayList<String> tags;


    public Usr(String username) {
        this.username = username;
        tags = new ArrayList<String>();
    }


    public ArrayList<String> getTags(){
        return tags;
    }

    void addTags(String name){
        tags.add(name);
    }


}
