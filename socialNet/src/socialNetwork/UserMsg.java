package socialNetwork;

/**
 * ClassName:UserMsg
 * extends from the Message class.
 * use to represent the user message
 * Version:2.0
 * Time : 12:57 20.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class UserMsg extends Message {


    public UserMsg() {
    }

    public UserMsg(String content, String author, int ageLimit, int privacy) {
        super(content, author, ageLimit, privacy);
    }

    @Override
    public String toString() {
        String s = "-------------author: "+super.getAuthor()+"-----------\n"
                +super.getContent()+"\n"+
                "----------------------------------------\ntimeStamp:" +
                super.getTimeStamp()+"\n\n\n";
        return s;
    }

    @Override
    public int getPrivacy() {
        return super.getPrivacy();
    }



}
