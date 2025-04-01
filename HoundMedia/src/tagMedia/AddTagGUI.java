package tagMedia;
import java.util.*;

public class AddTagGUI{
    public static void main(String[] args) {
        AddTagController controller = new AddTagController(new Usr("Test"));

        Scanner scnr = new Scanner(System.in);

// Get user new tag information
        System.out.println("Tag: ");
        String tag = scnr.next();
        System.out.println();


        // Initiate addMedia request
        Message attempt = controller.addTag(tag);
        System.out.println(attempt.print());
    }

}

