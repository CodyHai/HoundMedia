package Add;

import java.util.*;


public class User {
    String username;
    Day[][][] yearlyTracker;
    ArrayList<String> tags;


    public User(String username) {
        this.username = username;
        yearlyTracker = new Day[12][4][7];
        tags = new ArrayList<String>();
        populateMonths();
    }

    //populate for a one year tracker. Holds 12 months. And 28 days for each month
//(4 rows, 7 columns for simplicty)
    public void populateMonths() {
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 7; k++){
                    yearlyTracker[i][j][k] = new Day();
                }
            }
        }
    }

    public ArrayList<String> getTags(){
        return tags;
    }

    void addTags(String name){
        tags.add(name);
    }

    void addMedia(int month, int day, String name, String tag, double length){
        Media obj = new Media(name, tag, length);

        int spaceMonth = month - 1;
        int spaceRow = (day - 1) / 7;
        int spaceCol = (day - 1) % 7;

        yearlyTracker[spaceMonth][spaceRow][spaceCol].addMediaValue(obj);
    }

}
