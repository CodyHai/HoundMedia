package AddMedia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AddMediaControllerTest {

    @Test
    void messageTrue() {
        User u = new User("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddMediaController controller = new AddMediaController(u);
        Msg attempt = controller.addMedia("12", "17", "movieX", "movie", "360");
        assertEquals("Media object added\n", attempt.print());
    }

    @Test
    void errorLenghtoOfMedia() {
        User u = new User("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddMediaController controller = new AddMediaController(u);
        u.addTags("comedy");
        Msg attempt = controller.addMedia("8", "2", "The parenting", "comedy", "500.89");
        assertEquals("Lenght of media(minutes) is wrong\n", attempt.print());
    }

    @Test
    void errorLenghtoOfTag() {
        User u = new User("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddMediaController controller = new AddMediaController(u);
        u.addTags("comedy");
        Msg attempt = controller.addMedia("7", "7", "get out", "TagWithMoreThan25CharactersLong", "200");
        assertEquals("Tag does not exist\n", attempt.print());
    }

    @Test
    void errorLenghtoOfName() {
        User u = new User("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddMediaController controller = new AddMediaController(u);
        u.addTags("comedy");
        Msg attempt = controller.addMedia("6", "12", "Fast and Furious the second the sequel part 2", "comedy", "100.20");
        assertEquals("name is too long max 25 letters\n", attempt.print());
    }

    @Test
    void errorMonthWrong() {
        User u = new User("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddMediaController controller = new AddMediaController(u);
        u.addTags("comedy");
        Msg attempt = controller.addMedia("5", "30", "Love hurts", "comedy", "100.20");
        assertEquals("Date is wrong\n", attempt.print());
    }

    @Test
    void errorDayWrong() {
        User u = new User("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddMediaController controller = new AddMediaController(u);
        u.addTags("comedy");
        Msg attempt = controller.addMedia("30", "16", "Love hurts", "comedy", "100.20");
        assertEquals("Date is wrong\n", attempt.print());
    }


    //@org.junit.jupiter.api.Test
    //void addMedia() {
    //}
}