package Logout;

public class User 
{
    private String username; // holds the username
    private boolean status;
   
    public User() // default constructor
    {  

    }

    // constructor
    public User(String username, boolean status)
    {  
        this.username = username;
        this.status = status;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean getStatus()
    {
        return status;
    }


}
