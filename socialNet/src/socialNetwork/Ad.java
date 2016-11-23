package socialNetwork;

/**
 * ClassName:Ad
 * Version:1.0
 * Time : 23:20 19.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Ad extends Message{

    boolean paid;
    public Ad() {
    }

    public Ad(String content, String author, int ageLimit, int privacy, int timeStamp) {
        super(content, author, ageLimit, privacy, timeStamp);
    }

    public Ad(String content, String author, int ageLimit, int timeStamp, boolean paid) {
       super(content,author,ageLimit,timeStamp);
        this.paid = paid;
    }

    @Override
    public String toString() {
        String s = "-------------company: "+super.getAuthor()+"-----------\n\n"
                +super.getContent()+"\n"+ "timeStamp:"+super.getTimeStamp()+"\n\n\n";
        return s;
    }

}
