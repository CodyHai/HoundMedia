package Add;
import java.util.ArrayList;

public class AddMediaController{
    User u;


    public AddMediaController(User u) {
        this.u = u;
    }

    //In order to have pre-existing tags so it doesn't always return false
    public void existSomeTags(){
        u.addTags("book");
        u.addTags("movie");


    }
    public Msg addMedia(int month, int day, String name, String tag, double length) {
        // create a blank msg
        Msg msg = new Msg();

        // create an instance of DBMngr
        DBMngr db = new DBMngr();

        ArrayList<String> p = u.getTags();
        System.out.println(month);
        System.out.println(day);
        System.out.println(name);
        System.out.println(tag);
        System.out.println(length);

        existSomeTags();
        System.out.println(p.get(0));

        if(month < 13 && month > 0 && day < 29 && day > 0){
            if (p.contains(tag)) {
                // if associated with less than 2 users
                if (length > 0 && length < 480) {
                    // update permit with user's license plate
                    // add the permit to the user object
                    u.addMedia(month, day, name, tag, length);
                    msg.add("Media object added");
                }
                else {
                    msg.add("Lenght of media(minutes) is wrong");
                }
            }
            else
                msg.add("Tag does not exist");
        }
        // create a new Permit.Permit object with permit info
        else {
            msg.add("Date is wrong");
        }

        return msg;
    }
}