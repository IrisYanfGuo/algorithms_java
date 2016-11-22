package socialNetwork;

import datastru.*;


/**
 * Besides standard messages, the network should support advertisements.
 * These advertisement messages are posted by special kind of non-personal profiles
 * related to companies. Add support for distinguishing personal and corporate profiles
 * and support for advertisement messages.
 * <p>
 * When printing a wall, ads and normal messages are alternated: for every 4 user messages one ad is inserted.
 * Both messages and ads are sorted chronologically. The timestamp can be represented with an integer number where a higher number
 * corresponds with a newer message. Please note that messages are not necessarily chronologically posted to the network,
 * i.e. messages can be posted with a timestamp in the past or future.
 * <p>
 * version : 2.0 16/11/2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */


public class Network implements INetwork {
    private String name = "HOMEWORK";
    private LinkedList<User> usersInfo;
    private LinkedList<Company> companyInfo;
    private int timeStamp;


    public Network() {
        usersInfo = new LinkedList<>();
        companyInfo = new LinkedList<Company>();
    }

    @Override
    public String toString() {
        return "Network{}";
    }

    public void createUserProfile(String name, int age) {
        User t = new User(name, age);
        usersInfo.addFirst(t);
        t.getUsername();
    }

    public void createCorporateProfile(String name) {
        Company a = new Company(name);
        companyInfo.addFirst(a);
    }


    ///not finished function
    public void printWall(String username) {
        Profile a = findUser(username);
        if (a == null){
            System.out.println("can not find the user with this username");
        }

        else {
            a.printwall();
        }

    }

    public Profile findUser(String username){
        Profile a = null;
        boolean find = false;
        for (int i = 0; i < usersInfo.size(); i++) {
            a = usersInfo.get(i);
            String b = a.getUsername();
            if (b.equals(username)) {
                find = true;
                break;
            }
        }
        if (find == true) {
            return a;
        } else {
            return null;
        }
    }

    //not finished
    //postMsg function
    public void postMessage(String username, String message,
                            int privacy, int ageLimit, int timestamp) {
        Profile a = findUser(username);
        UserMsg m = new UserMsg(message,username,0,0);
        a.postUsrMsg(m);
    }

    public void postMsgList(LinkedList<User> a ,String username, String message,
                           int privacy, int ageLimit, int timestamp){
        UserMsg msg= new UserMsg(message,username,0,0);
        for (int i = 0;i<a.size();i++){
           a.get(i).postUsrMsg(msg);
        }
    }
    public void postMsgAll(String username, String message,
                           int privacy, int ageLimit, int timestamp){
        postMsgList(usersInfo,username,message,privacy,ageLimit,timestamp);
    }

    public void printUsr(){
        for (int i = 0; i < usersInfo.size(); i++) {
            System.out.println(usersInfo.get(i).getUsername());
        }
    }






    //post ad function
    public void printCom(){
        for (int i = 0; i <companyInfo.size() ; i++) {
            System.out.println(companyInfo.get(i).getName());
        }
    }

    public void postAd(String username, String message, int ageLimit,
                       boolean paid, int timestamp) {
        Profile a = findUser(username);
        Ad m = new Ad(message,username,ageLimit,timestamp);
        a.postAd(m);
    }


    public void postAdByList(LinkedList<User> usrList,String adContent,String companyName
                             ,int ageLimit,boolean paid,int timeStamp){
        Ad m = new Ad(adContent,companyName,ageLimit,timeStamp);
        for (int i = 0; i < usrList.size() ; i++) {
            usrList.get(i).postAd(m);
        }

    }

    public void postAdAll(String adContent,String companyName
            ,int ageLimit,boolean paid,int timeStamp){
        Ad m = new Ad(adContent,companyName,ageLimit,timeStamp);
        postAdByList(usersInfo,adContent,companyName,ageLimit,paid,timeStamp);
    }


    public void connect(String username1, String username2) {
    }

    public void printFriendList(String username) {
    }

    public void rate(String username, String corporateName, int stars) {
    }

    public int distance(String username1, String username2) {
        return 0; //unsolved
    }

    public void printPath(String username1, String username2) {
    }

    public int distanceExcludeCorporate(String username1, String username2) {
        return 0; // unsolved
    }

    public void printPathExcludeCorporate(String username1, String username2) {
    }


}
