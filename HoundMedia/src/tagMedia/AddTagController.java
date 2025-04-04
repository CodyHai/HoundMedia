package tagMedia;
import java.util.ArrayList;

class AddTagController{
    Usr u;


    public AddTagController(Usr u) {
        this.u = u;
    }

    //In order to have pre-existing tags so it doesn't always return false
    public void existSomeTags(){
        u.addTags("book");
        u.addTags("movie");


    }
    public Message addTag(String tag) {
        // create a blank msg
        Message msg = new Message();

        // create an instance of DBMngr
        DBManager db = new DBManager();

        ArrayList<String> p = u.getTags();

        if(tag.length() < 50 && tag.length() > 0){
            if (!p.contains(tag)) {
                    u.addTags(tag);
                    msg.add("tag added");
            }
            else
                msg.add("Tag already exists");
        }
        // create a new Permit.Permit object with permit info
        else {
            msg.add("Tag is wrong");
        }

        return msg;
    }
}
