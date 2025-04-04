package Logout;

import java.util.Scanner;

public class LogoutController 
{
    public static void main(String[] args) 
    {
        User user = null; // holds temporary user
        Message msg = new Message(); // new Message instance
        boolean match = false; // checks if the username matches
        DBManager database = new DBManager(); // creates new database instance
        Scanner scn = new Scanner(System.in);

        database.dbPopulate(); // populates database with dummy data

        System.out.print("Do you want to logout?\nEnter yes to logout, no to continue using the website. ");
        String input = scn.next(); // ho;ds user input

        if(input.compareToIgnoreCase("yes") ==  0) // if user wants to logout
        {
            do
            {
                System.out.print("Enter your username to confirm saving and logging out. ");
                String username = scn.next();

                user = new User(username);
                
                for(int i = 0; i < database.arrayList().size(); i++)
                {
                    if(database.arrayList().get(i).getUsername().equals(user.getUsername())) // checks if entered username is in databse
                    {
                        msg.logoutMsg(user);
                        msg.printMsg();
                        match = true;
                        break;
                    }
                
                }

                if(match == false) // if not in database, asks to re-enter
                {
                    System.out.println("Username does not match. Please retype to confirm logout.");
                }
                
            } while(match == false);
        }


        scn.close();
    }
}
