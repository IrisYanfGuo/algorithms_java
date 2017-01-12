package socialNetwork;

import datastru.*;

/**
 * A Profile class is a data structure for a personal information. It has 3 properties, username,age and a wall.
 * a wall is a linkedlist structure contains a list of messages
 * <p>
 * version:2.0  27/11/2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class Profile {

    private String username; //for user, it's username, but for company,it's company name
    private int age;
    /**
     * wall is used to represent the wall of this user
     * Adlist is a priorityqueue with ad, and use timeStamp as its'priority
     * FriMsg is a priotityqueue for storeing the Msg from friends
     * usrMsg is a queue storing the message from the user
     *for user, friList is a list for storing friends list; for company,friList is used for storing the subscriber list
     */
    private LinkedList<Message> wall;
    private PriorityQueue<Ad> adList;
    private PriorityQueue<UserMsg> usrMsg;
    private LinkedList <Profile> friList;

    // use to record rates
    private class Rate{

        String comName;
        /**
         * The Rate.
         */
        int rate;

        /**
         * Instantiates a new Rate.
         *
         * @param comName the com name
         * @param rate    the rate
         */
        public Rate(String comName, int rate) {
            this.comName = comName;
            this.rate = rate;
        }

        /**
         * Sets rate.
         *
         * @param rate the rate
         */
        public void setRate(int rate) {
            this.rate = rate;
        }

        /**
         * Gets rate.
         *
         * @return the rate
         */
        public int getRate() {
            return rate;
        }

        /**
         * Gets com name.
         *
         * @return the com name
         */
        public String getComName() {
            return comName;
        }

        @Override
        public String toString() {
            return "Rate{" +
                    "comName='" + comName + '\'' +
                    ", rate=" + rate +
                    '}';
        }
    }

    /**
     * The Rate vector. when a user rate a company, the name of the company as well as the rate will store in this vector
     */
    public Vector<Rate> rateVector;


    /**
     * Instantiates a new Profile.
     */
    public Profile() {
        // TODO Auto-generated constructor stub
        wall = new LinkedList<>();
        adList = new PriorityQueue<>();
        friList = new LinkedList<>();
        usrMsg = new PriorityQueue<>();
        rateVector = new Vector<>();
    }


    /**
     * Instantiates a new Profile.
     *
     * @param username the username
     * @param age      the age
     */
    public Profile(String username, int age) {
        this();
        this.age = age;
        this.username = username;
    }

    /**
     * Instantiates a new Profile.
     *
     * @param companyName the company name
     */
// only used in creating company profiles
    // and set all company age to -1
    public Profile(String companyName){
       this(companyName,-1);
    }

    @Override
    public String toString() {
        return "" + username;
    }

    /**
     * Post usr msg.
     *
     * @param m is a message          the function is to post a message to it's wall.
     */
    public void postUsrMsg(UserMsg m) {
        usrMsg.push(m,m.getTimeStamp());
    }


    /**
     * Post ad.
     *
     * @param ad the ad
     */
   //use timeStamp as priority
    public void postAd(Ad ad){
        adList.push(ad,ad.getTimeStamp());
    }

    /**
     * Post. here we generate the message in the wall.
     * the print function will call this method.
     */
    public void post(){
       // System.out.println(usrMsg.size());
        int c = usrMsg.size();
        //bug:here we can not use i<frimsg.size(),cause every time we pop,the size will minus 1.
        //add 4 messages then add one ad
        for (int i = 0; i <c ; i++) {
            if (i%4==0){
                Ad b = adList.pop();
                wall.addFirst(b);
            }
            wall.addFirst(usrMsg.pop());
        }


    }

    /**
     * Gets username.
     *
     * @return the username
     */
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

    /**
     * Sent msg.
     *
     * @param m        the m
     * @param privacy  the privacy
     * @param ageLimit the age limit
     */
    //sent message to friends
    public void sentMsg(String m,int privacy,int ageLimit){
        UserMsg meg = new UserMsg(m,username,ageLimit,privacy);
        for (int i = 0; i <friList.size() ; i++) {
            friList.get(i).postUsrMsg(meg);
        }
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }


    /**
     * Print a dlist.
     */
    //use this method to test some function
    public void printADlist(){
        for (int i = 0; i <adList.size() ; i++) {
            adList.getData().get(i).print();
        }
    }

    /**
     * Print fri list.
     */
    public void printFriList(){
        for (int i = 0; i <friList.size() ; i++) {
            System.out.println(friList.get(i).getUsername());
        }
    }

    //use this method to test some function

    /**
     * Print use msg list.
     * use in the test
     */
    private void printUseMsgList(){
        for (int i = 0; i <usrMsg.size() ; i++) {
            usrMsg.getData().get(i).print();
        }
    }

    /**
     * Add fri.
     * when adding a friend, simply add it to friendlist.
     *
     * @param a the a
     */
    public void addFri(Profile a){
        friList.addFirst(a);
    }

    /**
     * Get fri list linked list.
     *
     * @return the linked list
     */
    protected LinkedList<Profile> getFriList(){
        return friList;
    }

    /**
     * Add rate list.
     *
     * @param comName the com name
     * @param rate    the rate
     */
    public void addRateList(String comName, int rate){
        Rate a = new Rate(comName,rate);
        rateVector.addLast(a);

    }

    /**
     * Extra time.
     * it is used in push ad into adlist.
     * before pushing an add into priority queue, it will first it's rateVector, with per star get 3600 more timeStamp
     * @param comName the com name
     * @return the int
     */
    public int extraTime(String comName){
        for (int i = 0; i <rateVector.size() ; i++) {
            if (comName.equals(rateVector.get(i).getComName())){
                return rateVector.get(i).getRate()*3600;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Profile)obj).username.equals(username);
    }

    /**
     * override the method, if two Profiles's names are same, there are the same profile
     * that's means we can not create two different profile with the same name.
     *
     * @param a the a
     * @return the boolean
     */
    public boolean equals(Profile a){
        return a.username.equals(username);
    }

    /**
     * Print add.
     */
    public void printAdd(){
        System.out.println(adList.toString());
    }
}
