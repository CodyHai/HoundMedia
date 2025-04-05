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

    public User getUserAti(int i)
    {
        return usersList.get(i);
    }
    
    public void dbPopulate()
    {
        User user1 = new User("Awwab", false);
        User user2 = new User("Blessing", true);
        User user3 = new User("Cody", false);
        User user4 = new User("user2", true);
        User user5 = new User("user3", false);

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5);
    }
}
