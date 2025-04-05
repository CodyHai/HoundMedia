package Logout;

import java.util.Scanner;

public class LogoutController 
{
    DBManager database;
    Message msg; // new Message instance

    public LogoutController(DBManager database, Message msg)
    {
        this.database = database;
        this.msg = msg;
        database.dbPopulate();
    }

    public String logout(String username)
    {
        if (username == null)
        {
            msg.nullSession();
            return msg.getMessage();
        }

        if(username.isEmpty())
        {
            msg.invalidSession();
            return msg.getMessage();
        }
        
        User tempUser = new User(username, false);
        for(int i = 0; i < database.arrayList().size(); i++)
        {
            if(database.getUserAti(i).getUsername().equals(tempUser.getUsername()))
            {
                tempUser = database.getUserAti(i);
                break;
            }
        }

        if(tempUser.getStatus() == false)
        {
            msg.alreadyLogout();
            return msg.getMessage();
        }

        msg.sucessLogout();
        return msg.getMessage();

    }
    public static void main(String[] args) 
    {
        LogoutController controller = new LogoutController(new DBManager(), new Message());
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter your username to logout: ");
        String username = scn.nextLine();

        String output = controller.logout(username);
        System.out.println(output);

        scn.close();
    }
}
