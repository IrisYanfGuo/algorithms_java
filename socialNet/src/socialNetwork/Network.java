package socialNetwork;
/**
 * ClassName:Network implement the interface INetwork
 * it's the most important class.
 * Version:2.0
 * Time : 20:05 27.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com ></yanfguo@outlook.com><yanfguo@vub.ac.be>
 */

import datastru.*;

// if you want to find a user, try to use the findProfile function instead of writing a for loop to find it by your
//-self

/**
 * The type Network.
 */
public class Network implements INetwork {
    private String name = "HOMEWORK";
    //userInfo is a linkedList to store the information of user
    private LinkedList<Profile> usersInfo;
    //companyInfo is a linkedList to store the information of company
    private LinkedList<Profile> companyInfo;


    /**
     * Instantiates a new Network.
     */
    public Network() {
        usersInfo = new LinkedList<>();
        companyInfo = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Network{}";
    }

    public void createUserProfile(String name, int age) {
        Profile t = new Profile(name, age);
        usersInfo.addFirst(t);
    }
    public void createCorporateProfile(String name) {
        Profile a = new Profile(name);
        companyInfo.addFirst(a);
    }

    ///not finished function
    public void printWall(String username) {
        Profile a = findUser(username);
        if (a == null) {
            System.out.println("can not find the user with this username");
        } else {
            a.printWall();
        }

    }

    /**
     * Find user profile.
     *
     * @param username the username
     * @return the profile
     */
    public Profile findUser(String username) {

        for (int i = 0; i < usersInfo.size(); i++) {
            Profile temp = usersInfo.get(i);
            if (username.equals(temp.getUsername())){
                return temp;
            }
        }
        System.out.println("can not find the user :"+username);
        return null;
    }

    //not finished
    //postMsg function


    public Profile findCompany(String comName){
        for (int i = 0; i < companyInfo.size(); i++) {
            Profile temp = companyInfo.get(i);
            if (comName.equals(temp.getUsername())){
                return temp;
            }
        }
        System.out.println("can not find the user :"+comName);
        return null;
    }

    public void postMessage(String username, UserMsg message,
                            int privacy, int ageLimit) {
        Profile a = findUser(username);
        if (a.getAge() >= ageLimit) {
            message.setTimeStamp(TimeStamp.getTimeStamp());
            a.postUsrMsg(message);
        }
    }


    /**
     * Post msg list. used by the function postMessage
     *
     * @param a        the a
     * @param message  the message
     * @param privacy  the privacy
     * @param ageLimit the age limit
     */
    private void postMsgList(LinkedList<Profile> a, UserMsg message, int privacy, int ageLimit) {
        for (int i = 0; i < a.size(); i++) {
            postMessage(a.get(i).getUsername(), message, privacy, ageLimit);
        }
    }

    /**
     * Post msg to all people in this Network.
     *
     * @param message  the message
     * @param privacy  the privacy
     * @param ageLimit the age limit
     */
    public void postMsgAll(UserMsg message,
                           int privacy, int ageLimit) {
        postMsgList(usersInfo, message, privacy, ageLimit);
    }

    /**
     * Print user list
     */
    public void printUsr() {
        for (int i = 0; i < usersInfo.size(); i++) {
            System.out.println(usersInfo.get(i).getUsername());
        }
    }


    /**
     * Print company list
     */
//post ad function
    public void printCom() {
        for (int i = 0; i < companyInfo.size(); i++) {
            System.out.println(companyInfo.get(i).toString());
        }
    }


    //timeStamp should get from the system, and if the company is on the user's starList ,add it's timeStamp
    public void postAdByUser(String username, Ad ad, int ageLimit,
                             boolean paid) {
        Profile a = findUser(username);
        if (a.getAge() >= ageLimit) {
            int t = a.extraTime(ad.getAuthor());
            ad.setTimeStamp(TimeStamp.getTimeStamp()+t);
            a.postAd(ad);
        }
    }


    /**
     * Post ad by list.
     *
     * @param usrList  the usr list
     * @param ad       the ad
     * @param ageLimit the age limit
     * @param paid     the paid
     */
    private void postAdByList(LinkedList<Profile> usrList, Ad ad
            , int ageLimit, boolean paid) {
        for (int i = 0; i < usrList.size(); i++) {
            postAdByUser(usrList.get(i).getUsername(), ad, ageLimit, paid);
        }

    }

    /**
     * Post ad to all user in the Network
     *
     * @param adContent   the ad content
     * @param companyName the company name
     * @param ageLimit    the age limit
     * @param paid        the paid
     */
    public void postAdAll(Ad adContent, String companyName
            , int ageLimit, boolean paid) {

        postAdByList(usersInfo, adContent, ageLimit, paid);
    }


    public void connect(String username1, String username2) {
        Profile t1 =  findUser(username1);
        Profile t2 =  findUser(username2);
        if ((t1 != null) && (t2 != null)) {
            t1.addFri(t2);
            t2.addFri(t1);
        }else {
            System.out.println(" can not find the user");
        }
    }


    public void printFriendList(String username) {
        Profile t =  findUser(username);
        t.printFriList();
    }

    public void rate(String username, String corporateName, int stars) {
        Profile a =  findUser(username);
        a.addRateList(corporateName,stars);

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
