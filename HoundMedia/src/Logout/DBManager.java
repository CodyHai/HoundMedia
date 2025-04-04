package Logout;

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
    
    public void dbPopulate()
    {
        User user1 = new User("Awwab");
        User user2 = new User("Blessing");
        User user3 = new User("Cody");

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
    }
}
