package Login;
import java.util.ArrayList;

public class DBManager 
{
    ArrayList<User> usersList; // contains list of User objects
   
    public DBManager()
    {
        usersList = new ArrayList<>();
    }

    public ArrayList<User> arrayList()
    {
        return usersList;
    }

    public User getUserAti(int i)
    {
        return usersList.get(i);
    }

    //populates database for testing
    public void populateDB()
    {
        User user1 = new User("bobThebuilder", "i_love_building!123");
        User user2 = new User("hello_kitty123", "cat_lover456!");
        User user3 = new User("avi", "password");
        User user4 = new User("user2", "wh!tecloud2");

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
    }
}
