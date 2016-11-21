package socialNetwork;

/**
 * ClassName:UserMsg
 * Version:1.0
 * Time : 12:57 20.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class UserMsg extends Message {
    private String content;
    private String author;
    private int ageLimit; // age limit,the smallest age
    private int privacy;

    public UserMsg() {
    }

    public UserMsg(String content, String author, int ageLimit, int privacy) {
        this.content = content;
        this.author = author;
        this.ageLimit = ageLimit;
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        String s = "-------------author: "+author+"-----------\n"
                +content+"\n"+
                "----------------------------------------\n\n";
        return s;
    }

    @Override
    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }
}
