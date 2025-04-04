package Login;

import java.util.Scanner;
public class LoginController 
{
    public static void main(String[] args) 
    {
        DBManager database = new DBManager(); // creates an instance of DB
        Message msg = new Message(); // creates an instance of a message
        database.populateDB(); // populates db for testing
        boolean contains = false; // checks if a User is in the database

        Scanner scn = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scn.next();

        System.out.print("Please enter password: ");
        String password = scn.next();

        User tempUser = new User(username, password);
        User dbTempUser = new User(null, null);

        for(int i = 0; i < database.arrayList().size(); i++)
        {
            if(database.getUserAti(i).getUsername().equals(tempUser.getUsername()))
            {
                dbTempUser = database.getUserAti(i);
                contains = true; // the database contains the username
                break;
            }
        }

        if(contains) 
        {
            if(dbTempUser.getUsername().equals(tempUser.getUsername())) // if the username matches
            {
                if(dbTempUser.getPassword().equals(tempUser.getPassword())) // if the password ALSO matches
                {  
                    msg.add("Username and Password match.\n"); 
                    msg.add("Successful Login.");
                    msg.printMsg();
                }
                else
                {
                    msg.add("Username does not match password."); // username exists but password doesn't match
                    msg.printMsg();
                }
            }
        }
        else // the database does not contain the username
        {
            msg.add("User does not exist");
            msg.printMsg();
        }

       scn.close();

    }
}