package AddMedia;

import java.util.*;

public class AddMediaGUI{
    public static void main(String[] args) {
        AddMediaController controller = new AddMediaController(new User("Test"));

        Scanner scnr = new Scanner(System.in);

// Get user info to find position of where to add object
        System.out.println("Month: ");
        int month = scnr.nextInt();
        System.out.println();
        // Consume the newline left by nextInt()
        scnr.nextLine();

        System.out.println("day: ");
        int day = scnr.nextInt();
        System.out.println();
        // Consume the newline left by nextInt()
        scnr.nextLine();

        // Get media infromation to be added to the day and month
        System.out.println("Name of Media: ");
        String name = scnr.next();
        System.out.println();

        System.out.println("Tag of media: ");
        String tag = scnr.next();
        System.out.println();

        System.out.println("length of media(minutes): ");
        double length = scnr.nextDouble();
        System.out.println();
        // Consume the newline left by nextInt()
        scnr.nextLine();

        // Initiate addMedia request
        Msg attempt = controller.addMedia(month, day, name, tag, length);
        System.out.println(attempt.print());
    }

}
