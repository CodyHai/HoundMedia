package Login;

import java.util.Scanner;
public class LoginController 
{
    public DBManager database;
    public Message msg;

    public LoginController(DBManager database, Message msg)
    {
        this.database = database;
        this.msg = msg;
        database.populateDB();
    }

    public String login(String username, String password)
    {
        boolean contains = false; // checks if a User is in the database

        if(username == null) // checks for null username
        {
            msg.nullUsername();
            return msg.getMsg();
        }
        else if(password ==  null) // checks for null password
        {
            msg.nullPassword();
            return msg.getMsg();
        }

        if(username.isEmpty()) // checks for empty username
        {
            msg.noUsername();
            return msg.getMsg();
        }
        else if(password.isEmpty()) // checks for empty password
        {
            msg.noPassword();
            return msg.getMsg();
        }

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
                    msg.sucessLogin();
                    return msg.getMsg();
                }
                else
                {
                    msg.loginFail(); // username exists but password doesn't match
                    return msg.getMsg();
                }
            }
        }
       
        return "User does not exist";

    }
    public static void main(String[] args) 
    {
       
        LoginController controller = new LoginController(new DBManager(), new Message());
        Scanner scn = new Scanner(System.in);

        System.out.print("Please enter username: ");
        String username = scn.nextLine();

        System.out.print("Please enter password: ");
        String password = scn.nextLine();

        scn.close(); // need to close scn here to use return statements for termination

        String result = controller.login(username, password);
        System.out.println(result);
    
    }
}