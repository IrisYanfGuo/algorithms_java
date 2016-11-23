package socialNetwork;

import datastru.*;


public class Network implements INetwork {
    private String name = "HOMEWORK";
    private LinkedList<User> usersInfo;
    private LinkedList<Company> companyInfo;
    private int timeStamp=TimeStamp.getTimeStamp();


    public Network() {
        usersInfo = new LinkedList<>();
        companyInfo = new LinkedList<>();
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
            a.printWall();
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


    public void postMessage(String username,UserMsg message,
                            int privacy, int ageLimit) {
        Profile a = findUser(username);
        message.setTimeStamp(TimeStamp.getTimeStamp());
        a.postUsrMsg(message);
    }


    public void postMsgList(LinkedList<User> a ,UserMsg message,int privacy,int ageLimit){
        for (int i = 0;i<a.size();i++){
          postMessage(a.get(i).getUsername(),message,privacy,ageLimit);
        }
    }

    public void postMsgAll(UserMsg message,
                           int privacy, int ageLimit){
        postMsgList(usersInfo,message,privacy,ageLimit);
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


    //timeStamp should getfrom the system, so get rid of the parameter of timeStamp
    public void postAdByUser(String username, Ad ad, int ageLimit,
                       boolean paid) {
        Profile a = findUser(username);
        ad.setTimeStamp(TimeStamp.getTimeStamp());
        a.postAd(ad);
    }


    public void postAdByList(LinkedList<User> usrList,Ad ad
                             ,int ageLimit,boolean paid){
        for (int i = 0; i < usrList.size() ; i++) {
            postAdByUser(usrList.get(i).getUsername(),ad,ageLimit,paid);
        }

    }

    public void postAdAll(Ad adContent,String companyName
            ,int ageLimit,boolean paid){
        postAdByList(usersInfo,adContent,ageLimit,paid);
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
