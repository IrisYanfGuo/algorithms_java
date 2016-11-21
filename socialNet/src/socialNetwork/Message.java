package socialNetwork;

/**
 * A Message class is a data structure for a message showing on the wall. It contains 5 property, content,author,
 * largeage and privacy.And to get and set these properties, all this properties have getPropertity
 * and set Property function.
 * version:1.0 time 7th Nov
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */


public class Message {

    private String content;
    private String author;
    private int ageLimit; // age limit,the smallest age
    private int privacy; // 0 is public, 1friends ,2 friends of friends
    private int timeStamp;


    public Message() {
        // TODO Auto-generated constructor stub
    }

    public Message(String content, String author, int ageLimit, int privacy) {
        // TODO Auto-generated constructor stub
        this.content = content;
        this.author = author;
        this.ageLimit = ageLimit;
        this.privacy = privacy;
    }

    public Message(String content, String author, int privacy) {
        this.content = content;
        this.author = author;
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", ageLimit=" + ageLimit +
                ", privacy=" + privacy +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public int getPrivacy() {
        return privacy;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void print() {
        System.out.println(toString());
    }

}
