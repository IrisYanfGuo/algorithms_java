package socialNetwork;

/**
 * ClassName:Ad
 * Version:1.0
 * Time : 23:20 19.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Ad extends Message{
    private String content;
    private String companyName;
    private int ageLimit;
    private int timeStamp;

    public Ad() {
    }

    public Ad(String content, String companyName) {
        this.content = content;
        this.companyName = companyName;
    }

    public Ad(String content, String companyName, int ageLimit, int timeStamp) {
        this.content = content;
        this.companyName = companyName;
        this.ageLimit = ageLimit;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        String s = "-------------company: "+companyName+"-----------\n\n"
                +content+"\n"+
                "\n\n";
        return s;
    }

}
