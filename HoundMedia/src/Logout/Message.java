package Logout;

public class Message 
{
    public String msg; // holds the message string

    public Message()
    {
        msg = "";
    }

    public void logoutMsg(User user) // concatenates the msg to the emmpty string
    {
        this.msg += user.getUsername() + " is now logged out.";
    }

    public void printMsg() // displays the msmg
    {
        System.out.println(this.msg);
    }
}
