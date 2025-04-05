package Logout;

public class Message 
{
    public String msg; // holds the message string

    public Message()
    {
        msg = "";
    }

    public void sucessLogout() // concatenates the msg to the emmpty string
    {
        this.msg = "Logout Successful";
    }

    public void alreadyLogout() // concatenates the msg to the emmpty string
    {
        this.msg = "Error: Already logged out";
    }

    public void invalidSession() // concatenates the msg to the emmpty string
    {
        this.msg = "Error: Invalid session";
    }

    public void nullSession() // concatenates the msg to the emmpty string
    {
        this.msg = "Errro: Null session";
    }

    public String getMessage()
    {
        return this.msg;
    }

}
