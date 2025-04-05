package Login;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class LoginControllerTest 
{
    DBManager database;
    Message msg;
    LoginController controller;

    @BeforeEach
    public void setup()
    {
        database = new DBManager();
        msg = new Message();
        controller = new LoginController(database, msg);
        database.populateDB();
    }

    @Test
    public void testSuccessfulLogin()
    {
        String result = controller.login("user2", "wh!tecloud2");
        assertEquals("Login Successful", result);
    }

    @Test
    public void testFailedLogin()
    {
        String result = controller.login("user2", "whitecloudtwo");
        assertEquals("Login Failed", result);
    }

    @Test
    public void testPasswordReq()
    {
        String result = controller.login("user2", "");
        assertEquals("Error: Password Required", result);
    }

    @Test
    public void testUsernameReq()
    {
        String result = controller.login("", "wh!tecloud2");
        assertEquals("Error: Username Required", result);
    }

    @Test
    public void nullPassword()
    {
        String result = controller.login("user2", null);
        assertEquals("Error: Null Password", result);
    }

    @Test
    public void nullUser()
    {
        String result = controller.login(null, "wh!cloud2");
        assertEquals("Error: Null Username", result);
    }


}
