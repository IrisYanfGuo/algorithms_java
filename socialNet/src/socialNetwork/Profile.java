package socialNetwork;

import datastru.*;

/**
 * A Profile class is a data structure for a personal information. It has 3 properties, username,age and a wall.
 * a wall is a linkedlist structure contains a list of messages
 * <p>
 * version:2.0  16/11/2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */

public class Profile {

    private String username;
    private int age;
    public LinkedList<Message> wall;
    private LinkedList<Ad> adList;
    private LinkedList<UserMsg> friMsg;
    private LinkedList <Profile> friList;


    public Profile() {
        // TODO Auto-generated constructor stub
        wall = new LinkedList<>();
        adList = new LinkedList<>();
        friList = new LinkedList<>();
        friMsg = new LinkedList<>();
    }



    public Profile(String username, int age) {
        this();
        this.age = age;
        this.username = username;
    }


    @Override
    public String toString() {
        return "Profile: " + username + age;
    }

    /**
     * @param m is a message
     *          the function is to post a message to it's wall.
     */

    // unclear the function of post ,may overwrite it later
    public void postUsrMsg(UserMsg m) {
        friMsg.addFirst(m);
    }

    public void postAd(Ad ad){
        adList.addFirst(ad);
    }

    public void post(){
        for (int i = 0; i <friMsg.size() ; i++) {
            if (i%4==0){
                adList.popFirst().print();
            }
            friMsg.get(i).print();

        }
    }

    public boolean compareByName(String username) {
        return username == this.username;
    }


    public String getUsername() {
        return username;
    }

    public void printwall(){
        System.out.println("this is "+username+"'s wall");
        System.out.print("\n");
        post();
        System.out.println(wall.toString());
    }
}
