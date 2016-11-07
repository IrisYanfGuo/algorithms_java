package socialNetworks;

/**
 * Besides standard messages, the network should support advertisements.
 * These advertisement messages are posted by special kind of non-personal profiles
 * related to companies. Add support for distinguishing personal and corporate profiles
 * and support for advertisement messages.
 *
 * When printing a wall, ads and normal messages are alternated: for every 4 user messages one ad is inserted.
 *  Both messages and ads are sorted chronologically. The timestamp can be represented with an integer number where a higher number
 *  corresponds with a newer message. Please note that messages are not necessarily chronologically posted to the network,
 *  i.e. messages can be posted with a timestamp in the past or future.

 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */

public class Network {
    LinkedList usersInfo;
    LinkedList companyInfo;
    public Network() {
        LinkedList a = new LinkedList();
    }

    @Override
    public String toString() {
        return "Network{}";
    }

    public void createUserProfile(String name, int age){
        Profile t = new Profile(name,age);
        usersInfo.addFirst(t);
    }

    public void createCorporateProfile(String name){
        companyInfo.addFirst(name);
    }

    public void printWall(String username){

    }

    public void postMessage(String username, String messsage, int ageLimit, int timestamp){

    }

    public void postAd(String username,String message, int ageLimit, int timestamp){

    }


}
