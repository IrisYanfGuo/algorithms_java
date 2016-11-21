package socialNetwork;

/**
 * InterfaceName:INetwork
 * Version:1.0
 * Time : 21:34 19.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public interface INetwork {
    void createUserProfile(String name, int age);

    void createCorporateProfile(String name);

    void printWall(String username);

    void postMessage(String username, String message,
                     int privacy, int ageLimit, int timestamp);

    void postAd(String username, String message, int ageLimit,
                boolean paid, int timestamp);

    void connect(String username1, String username2);

    void printFriendList(String username);

    void rate(String username, String corporateName, int stars);

    int distance(String username1, String username2);

    void printPath(String username1, String username2);

    int distanceExcludeCorporate(String username1, String username2);

    void printPathExcludeCorporate(String username1, String username2);

}
