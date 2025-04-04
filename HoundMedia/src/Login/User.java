package Login;

public class User 
{
    private String username; // holds the username
    private String password; // holds the password


    // constructor
    public User(String username, String password)
    {  
        this.username = username;
        this.password = password;
    }

    // gets the username of the user
    public String getUsername()
    {
        return username;
    }

    // gets the password of the user
    public String getPassword()
    {
        return password;
    }

    // checks whether the username is correct or not
    public boolean correctUsername(String usernameIn)
    {
        if(usernameIn.length() > 25) // username length must be <= 25 characters
        {
            return false; 
        }

        if(username.equals(usernameIn))
        {
            return true;
        }
        
        return false;
    }

    // checks whether the password is correct or not
    public boolean correctPassword(String passwordIn)
    {
        if(passwordIn.length() > 25) // password length must be <= 25 characters
        {
            return false;
        }

        if(password.equals(passwordIn))
        {
            return true;
        }

        return false;
    }


}