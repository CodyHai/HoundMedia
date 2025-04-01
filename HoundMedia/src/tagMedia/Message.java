package tagMedia;

public class Message {
    String message;

    public Message() {
        message = "";
    }

    public void add(String message) {
        this.message += message +"\n";
    }

    public String print() {
        return message;
    }
}
