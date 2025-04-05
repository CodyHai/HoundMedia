package Login;

public class Message 
{
    public String msg; // holds the message string

    public Message()
    {
        msg = "";
    }

    public void sucessLogin() // concatenates the msg to the emmpty string
    {
        this.msg = "Login Successful";
    }

    public void loginFail()
    {
        this.msg = "Login Failed";
    }

    public void noPassword()
    {
        this.msg = "Error: Password Required";
    }

    public void noUsername()
    {
        this.msg = "Error: Username Required";
    }

    public void nullPassword()
    {
        this.msg = "Error: Null Password";
    }

    public void nullUsername()
    {
        this.msg = "Error: Null Username";
    }
    
    public String getMsg() // displays the msmg
    {
        return this.msg;
    }
}
