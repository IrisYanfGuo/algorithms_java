package socialNetwork;

/**
 * A Message class is a data structure for a message showing on the wall. It contains 5 property, content,author,
 * largeage and privacy.And to get and set these properties, all this properties have getPropertity
 * and set Property function.
 * version:2.0 time 27th Nov
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */


public class Message {

    private String content;
    private String author;
    private int ageLimit; // age limit,the smallest age
    private int privacy; // 0 is public, 1friends ,2 friends of friends
    private int timeStamp;


    /**
     * Instantiates a new Message.
     */
    public Message() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Message.
     *
     * @param content  the content
     * @param author   the author
     * @param ageLimit the age limit
     * @param privacy  the privacy
     */
    public Message(String content, String author, int ageLimit, int privacy) {
        // TODO Auto-generated constructor stub
        this.content = content;
        this.author = author;
        this.ageLimit = ageLimit;
        this.privacy = privacy;
        this.timeStamp = TimeStamp.getTimeStamp();
    }

    /**
     * Instantiates a new Message.
     *
     * @param content  the content
     * @param author   the author
     * @param ageLimit the age limit
     */
// used in Ad Class, without privacy
    public Message(String content, String author, int ageLimit) {
        this.content = content;
        this.author = author;
        this.ageLimit = ageLimit;
        this.timeStamp = TimeStamp.getTimeStamp();
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

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets age limit.
     *
     * @return the age limit
     */
    public int getAgeLimit() {
        return ageLimit;
    }

    /**
     * Gets privacy.
     *
     * @return the privacy
     */
    public int getPrivacy() {
        return privacy;
    }

    /**
     * Gets time stamp.
     *
     * @return the time stamp
     */
    public int getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets time stamp.
     *
     * @param timeStamp the time stamp
     */
    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Print.
     */
    public void print() {
        System.out.println(toString());
    }

}
