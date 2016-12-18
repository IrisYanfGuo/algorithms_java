package socialNetwork;

/**
 * InterfaceName:INetwork
 * Version:1.0
 * Time : 21:34 19.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public interface INetwork {
    /**
     * Create user profile.
     * @param name the name of the user
     * @param age  the age
     */
    void createUserProfile(String name, int age);

    /**
     * Create corporate profile.
     *
     * @param name the name of the company
     */
    void createCorporateProfile(String name);

    /**
     * Print username's wall
     *
     * @param username the username
     */
    void printWall(String username);

    /**
     * Post message to user by his or her username
     *
     * @param username the username
     * @param message  the message created by user
     * @param privacy  the privacy, with 0 public ,1 to friends ,2 friends of friends
     * @param ageLimit the age limit
     */
    void postMessage(String username, UserMsg message,
                     int privacy, int ageLimit);

    /**
     * Post ad to user by it's user name.
     *
     * @param username the username
     * @param message  the message
     * @param ageLimit the age limit
     * @param paid     the paid
     */
    void postAdByUser(String username, Ad message, int ageLimit,
                boolean paid);

    /**
     * connect
     *ad user2 to user1's friendlist, and also ad user2 to user1's friendlist
     * @param username1 the username 1
     * @param username2 the username 2
     */
    void connect(String username1, String username2);

    /**
     * Print user's friendlist
     *
     * @param username the username
     */
    void printFriendList(String username);

    /**
     * Rate.
     *
     * @param username      the username
     * @param corporateName the corporate name
     * @param stars         the stars
     */
    void rate(String username, String corporateName, int stars);

    /**
     * Distance int.
     *
     * @param username1 the username 1
     * @param username2 the username 2
     * @return the int
     */
    int distance(String username1, String username2);

    /**
     * Print path.
     *
     * @param username1 the username 1
     * @param username2 the username 2
     */
    void printPath(String username1, String username2);

    /**
     * Distance exclude corporate int.
     *
     * @param username1 the username 1
     * @param username2 the username 2
     * @return the int
     */
    int distanceExcludeCorporate(String username1, String username2);

    /**
     * Print path exclude corporate.
     *
     * @param username1 the username 1
     * @param username2 the username 2
     */
    void printPathExcludeCorporate(String username1, String username2);

}
