package socialNetwork;
/**
 * ClassName:Network implement the interface INetwork
 * it's the most important class.
 * Version:2.0
 * Time : 20:05 27.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com><yanfguo@vub.ac.be>
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

    private GraphList<Profile> graph;

    private GraphList<Profile> graphWithoutCom;

    /**
     * Instantiates a new Network.
     */
    public Network() {
        usersInfo = new LinkedList<>();
        companyInfo = new LinkedList<>();
        graph = new GraphList<>();
        graphWithoutCom = new GraphList<>();
    }


    @Override
    public String toString() {
        return "Network{}";
    }

    public void createUserProfile(String name, int age) {
        Profile t = new Profile(name, age);
        usersInfo.addFirst(t);
        graph.addNode(t);
        graphWithoutCom.addNode(t);
    }

    public void createCorporateProfile(String name) {
        Profile a = new Profile(name);
        companyInfo.addFirst(a);
        graph.addNode(a);
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
            if (username.equals(temp.getUsername())) {
                return temp;
            }
        }
        System.out.println("can not find the user :" + username);
        return null;
    }

    //not finished
    //postMsg function


    /**
     * Find company profile.
     *
     * @param comName the com name
     * @return the profile
     */
    public Profile findCompany(String comName) {
        for (int i = 0; i < companyInfo.size(); i++) {
            Profile temp = companyInfo.get(i);
            if (comName.equals(temp.getUsername())) {
                return temp;
            }
        }


        System.out.println("can not find by name :" + comName);
        return null;
    }


    /**
     * Find by name profile.
     *
     * @param name the name, you can use both company name and user name
     * @return the profile
     */
// search the userInfo list and Company List
    public Profile findByName(String name) {
        for (int i = 0; i < companyInfo.size(); i++) {
            Profile temp = companyInfo.get(i);
            if (name.equals(temp.getUsername())) {
                return temp;
            }
        }

        for (int i = 0; i < usersInfo.size(); i++) {
            Profile temp = usersInfo.get(i);
            if (name.equals(temp.getUsername())) {
                return temp;
            }
        }
        System.out.println("can not find the user :" + name);
        return null;
    }



    private void postMessage(String username, UserMsg message,
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
    private void postMsgAll(UserMsg message,
                           int privacy, int ageLimit) {
        postMsgList(usersInfo, message, privacy, ageLimit);
    }


    /**
     * Post message.
     *
     * @param message  the message
     * @param privacy  the privacy
     * @param ageLimit the age limit
     */
    public void postMessage(UserMsg message, int privacy, int ageLimit) {
        if (privacy == 0) {
            postMsgAll(message, privacy, ageLimit);
        } else if (privacy == 1) {
            postMsgList(findUser(message.getAuthor()).getFriList(), message, privacy, ageLimit);
        } else {
            String author = message.getAuthor();
            LinkedList<Profile> temp = new LinkedList<>();
            Profile a = findUser(author);
            for (int i = 0; i < a.getFriList().size(); i++) {
                temp.append(a.getFriList().get(i).getFriList());
            }
            postMsgList(temp, message, privacy, ageLimit);
        }
    }

    public void postAD(Ad ad,String companyName,int agelimit,boolean paid){
        Profile com = findCompany(companyName);
        if (paid==true){
            for (int i = 0; i < com.getFriList().size(); i++) {
                Profile temp = com.getFriList().get(i);
                if (temp.getAge()>agelimit){
                    temp.postAd(ad);
                }
            }
        }else {
            postAdAll(ad,companyName,agelimit,paid);

            }
        }

    /**
     * Print user list, only used when test. if you want to see the user list, simply change private to public
     */
    private void printUsr() {
        for (int i = 0; i < usersInfo.size(); i++) {
            System.out.println(usersInfo.get(i).getUsername());
        }
    }


    /**
     * Print company list
     * use to test, if you want to test the network ,simply change private to public
     */
//post ad function
    private void printCom() {
        for (int i = 0; i < companyInfo.size(); i++) {
            System.out.println(companyInfo.get(i).toString());
        }
    }


    //timeStamp should get from the system, and if the company is on the user's starList ,add it's timeStamp
    public void postAdByUser(String username, Ad ad, int ageLimit,
                             boolean paid) {
        Profile a = findUser(username);
        int t = a.extraTime(ad.getAuthor());
        ad.setTimeStamp(TimeStamp.getTimeStamp() + t);
        if (paid == true) {
            LinkedList<Profile> temp = findCompany(ad.getAuthor()).getFriList();
            for (int i = 0; i <temp.size() ; i++) {
                if (username==temp.get(i).getUsername()){
                    a.postAd(ad);
                }
            }

        } else {
            if (a.getAge() >= ageLimit) {

                a.postAd(ad);
            }
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
        Profile t1 = findUser(username1);
        Profile t2 = findUser(username2);
        if ((t1 != null) && (t2 != null)) {
            t1.addFri(t2);
            t2.addFri(t1);
            graph.addEdge(t1, t2);
            graph.addEdge(t2, t1);
            graphWithoutCom.addEdge(t2, t1);
            graphWithoutCom.addEdge(t1, t2);
        } else {
            System.out.println(" can not find the user");
        }
    }

    /**
     * Connect com user.
     *
     * @param userName the user name
     * @param comName  the com name
     */
    public void connectCom_User(String userName, String comName) {
        Profile user = findUser(userName);
        Profile com = findCompany(comName);

        if ((user != null) && (com != null)) {
            user.addFri(com);
            com.addFri(user);
            graph.addEdge(user, com);
            graph.addEdge(com, user);
        } else {
            System.out.println(" can not find the user");
        }
    }


    public void printFriendList(String username) {
        Profile t = findUser(username);
        t.printFriList();
    }

    public void rate(String username, String corporateName, int stars) {
        Profile a = findUser(username);
        //Profile com = findCompany(corporateName);
        connectCom_User(username, corporateName);
        a.addRateList(corporateName, stars);
    }

    public int distance(String username1, String username2) {
        Profile a = findUser(username1);
        Profile b = findUser(username2);

        Vector<Vector<GraphList<Profile>.Node>> result = graph.dijkstra(a);
        GraphList.Node t = graph.findNode(b);

        return (result.get(t.getIvex())).size() - 1;
    }

    public void printPath(String username1, String username2) {
        Profile a = findUser(username1);
        Profile b = findUser(username2);

        Vector<Vector<GraphList<Profile>.Node>> result = graph.dijkstra(a);
        GraphList.Node t = graph.findNode(b);
        Vector<GraphList<Profile>.Node> temp = result.get(t.getIvex());
        System.out.print("Path from " + username1 + " to " + username2 + "(include com): ");
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i));
            if (i < temp.size() - 1) {
                System.out.print("->");
            }
        }
        // System.out.println(temp);
    }

    public int distanceExcludeCorporate(String username1, String username2) {

        Profile a = findUser(username1);
        Profile b = findUser(username2);

        Vector<Vector<GraphList<Profile>.Node>> result = graphWithoutCom.dijkstra(a);
        GraphList.Node t = graphWithoutCom.findNode(b);

        return (result.get(t.getIvex())).size() - 1;
    }

    public void printPathExcludeCorporate(String username1, String username2) {
        Profile a = findUser(username1);
        Profile b = findUser(username2);

        Vector<Vector<GraphList<Profile>.Node>> result = graphWithoutCom.dijkstra(a);
        GraphList.Node t = graphWithoutCom.findNode(b);
        Vector<GraphList<Profile>.Node> temp = result.get(t.getIvex());
        System.out.print("Path from " + username1 + " to " + username2 + "(exclude com): ");
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i));
            if (i < temp.size() - 1) {
                System.out.print("->");
            }
        }

    }


}
