package socialNetwork;

/**
 * ClassName:TimeStamp
 * the TimeStamp is a class to control the timeStamp of the entire program.
 * it use a static function get TimeStamp and static variable timeStamp.
 * everytime this function called, the timeStamo++;
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

        return (int)System.currentTimeMillis()/1000;
    }


}
