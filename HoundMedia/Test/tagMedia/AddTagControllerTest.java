package tagMedia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AddTagControllerTest {

    @Test
    void messageTrue() {
        Usr u = new Usr("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddTagController controller = new AddTagController(u);
        Message attempt = controller.addTag("Action");
        assertEquals("tag added\n", attempt.print());
    }

    @Test
    void tooLongTag() {
        Usr u = new Usr("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddTagController controller = new AddTagController(u);
        Message attempt = controller.addTag("TagWithMoreThan25CharactersLong");
        assertEquals("Tag is wrong\n", attempt.print());
    }

    @Test
    void noTag() {
        Usr u = new Usr("Test");
        //u.addTags("movie"); // or "Action" if you want that tag
        AddTagController controller = new AddTagController(u);
        Message attempt = controller.addTag("");
        assertEquals("Tag is wrong\n", attempt.print());
    }

}