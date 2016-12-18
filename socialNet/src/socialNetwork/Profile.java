package socialNetwork;

import datastru.*;

/**
 * A Profile class is a data structure for a personal information. It has 3 properties, username,age and a wall.
 * a wall is a linkedlist structure contains a list of messages
 *
 * version:2.0  27/11/2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */

public class Profile {

    private String username; //for user, it's username, but for company,it's company name
    private int age;
    /**
     * wall is used to represent the wall of this user
     * Adlist is a queue with ad
     * FriMsg is a queue for storeing the Msg from friends
     * usrMsg is a queue storing the message from the user
     *for user, friList is a list for storing friends list; for company,friList is used for storing the subscriber list
     */
    public LinkedList<Message> wall;
    private PriorityQueue<Ad> adList;
    private PriorityQueue<UserMsg> usrMsg;
    private LinkedList <Profile> friList;

    // use to record rates
    private class Rate{
        String comName;
        int rate;

        public Rate(String comName, int rate) {
            this.comName = comName;
            this.rate = rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getRate() {
            return rate;
        }

        public String getComName() {
            return comName;
        }
    }

    private Vector<Rate> rateVector;


    public Profile() {
        // TODO Auto-generated constructor stub
        wall = new LinkedList<>();
        adList = new PriorityQueue<>();
        friList = new LinkedList<>();
        usrMsg = new PriorityQueue<>();
        rateVector = new Vector<>();
    }



    public Profile(String username, int age) {
        this();
        this.age = age;
        this.username = username;
    }

    // only used in creating company profiles
    // and set all company name to -1
    public Profile(String companyName){
       this(companyName,-1);
    }

    @Override
    public String toString() {
        return "Profile: " + username;
    }

    /**
     * @param m is a message
     *          the function is to post a message to it's wall.
     */

    // unclear the function of post ,may overwrite it later
    public void postUsrMsg(UserMsg m) {
        usrMsg.push(m,m.getTimeStamp());
    }


    //use timeStamp as priority
    public void postAd(Ad ad){
        adList.push(ad,ad.getTimeStamp());
    }

    public void post(){
        System.out.println(usrMsg.size());
        int c = usrMsg.size();
        //here we can not use i<frimsg.size(),cause every time we pop,the size will minus 1.
        for (int i = 0; i <c ; i++) {
            if (i%4==0){
                Ad b = adList.pop();
                wall.addFirst(b);
            }
            wall.addFirst(usrMsg.pop());
        }


    }

    public boolean compareByName(String username) {
        return username == this.username;
    }


    public String getUsername() {
        return username;
    }


    /**
     * Print wall. use the function post to generate the wall, and then print the Message.
     */
    public void printWall(){
        System.out.println("this is "+username+"'s wall");
        System.out.print("\n");
        post();
        System.out.println(wall.toString());
    }

    //sent message to friends
    public void sentMsg(String m,int privacy,int ageLimit){
        UserMsg meg = new UserMsg(m,username,ageLimit,privacy,0);
        for (int i = 0; i <friList.size() ; i++) {
            friList.get(i).postUsrMsg(meg);
        }
    }

    public int getAge() {
        return age;
    }


    //use this method to test some function
    public void printADlist(){
        for (int i = 0; i <adList.size() ; i++) {
            adList.getData().get(i).print();
        }
    }

    public void printFriList(){
        for (int i = 0; i <friList.size() ; i++) {
            System.out.println(friList.get(i).getUsername());
        }
    }

    //use this method to test some function

    public void printUseMsgList(){
        for (int i = 0; i <usrMsg.size() ; i++) {
            usrMsg.getData().get(i).print();
        }
    }

    public void addFri(Profile a){
        friList.addFirst(a);
    }

    protected LinkedList<Profile> getFriList(){
        return friList;
    }

    public void addRateList(String comName, int rate){
        Rate a = new Rate(comName,rate);
        rateVector.addLast(a);

    }

    public int extraTime(String comName){
        for (int i = 0; i <rateVector.size() ; i++) {
            if (comName==rateVector.get(i).getComName()){
                return rateVector.get(i).getRate()*3600;
            }
        }
        return 0;
    }


}
