package Logout;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutControllerTest 
{
    DBManager database;
    Message msg;
    LogoutController controller;

    @BeforeEach
    public void setup()
    {
        database = new DBManager();
        msg = new Message();
        controller = new LogoutController(database, msg);
        database.dbPopulate();
    }

    @Test
    public void sucessfulLogout()
    {
        String result = controller.logout("user2");
        assertEquals("Logout Successful", result);
    }

    @Test
    public void alreadyLoggedOut()
    {
        String result = controller.logout("user3");
        assertEquals("Error: Already logged out", result);
    }

    @Test
    public void invalidSession()
    {
        String result = controller.logout("");
        assertEquals("Error: Invalid session", result);
    }

    @Test
    public void nullSession()
    {
        String result = controller.logout(null);
        assertEquals("Errro: Null session", result);
    }

}
