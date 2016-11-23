package socialNetwork;

/**
 * ClassName:TimeStamp
 * Version:1.0
 * Time : 00:51 23.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class TimeStamp {
    public TimeStamp() {
    }
    private static int timeStamp=0;

    public static int getTimeStamp() {
        timeStamp++;
        return timeStamp;
    }


}
