package AddMedia;
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
    public Msg addMedia(String month, String day, String name, String tag, String length) {
        // create a blank msg
        Msg msg = new Msg();

        // create an instance of DBMngr
        DBMngr db = new DBMngr();

        ArrayList<String> p = u.getTags();
        //System.out.println(month);
        //System.out.println(day);
        //System.out.println(name);
        //System.out.println(tag);
        //System.out.println(length);

        existSomeTags();
        //System.out.println(p.get(0));
        try {
            int monthVal = Integer.parseInt(month);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid inputs");
        }
        int monthVal = Integer.parseInt(month);

        try {
            int dayVal = Integer.parseInt(day);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid inputs");
        }
        int dayVal = Integer.parseInt(day);

        try {
            double lengthVal = Double.parseDouble(length);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid inputs");
        }
        double lengthVal = Double.parseDouble(length);


        if(monthVal < 13 && monthVal > 0 && dayVal < 29 && dayVal > 0){
            if (p.contains(tag)) {
                // if associated with less than 2 users
                if (lengthVal > 0 && lengthVal < 480) {
                    // update permit with user's license plate
                    // add the permit to the user object
                    if(name.length() > 0 && name.length() < 26) {
                        u.addMedia(monthVal, dayVal, name, tag, lengthVal);
                        msg.add("Media object added");
                        return msg;
                    }
                    else {
                        msg.add("name is too long max 25 letters");
                        return msg;
                    }
                }
                else {
                    msg.add("Lenght of media(minutes) is wrong");
                    return msg;
                }
            }
            else {
                msg.add("Tag does not exist");
                return msg;
            }

        }
        // create a new Permit.Permit object with permit info
        else {
            msg.add("Date is wrong");
        }

        return msg;
    }
}