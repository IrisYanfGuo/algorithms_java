package socialNetworks;

/**
 *A Profile class is a data structure for a personal information. It has 3 properties, username,age and a wall.
 *a wall is a linkedlist structure contains a list of messages
 * version:1.0 time 7th Nov
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */

public class Profile {

	private String username;
	private int age;
	public LinkedList wall;

	public Profile() {
		// TODO Auto-generated constructor stub
		wall = new LinkedList();
	}

	public Profile(String username, int age) {
		this();
		this.age = age;
		this.username = username;

	}

	@Override
	public String toString() {
		return "Profile: " +username + age;
	}

	/**
	 * @param m is a message
	 * the function is to post a message to it's wall.
	 */
	public void post( Message m	) {
		wall.addFirst(m);
	}

	
	
}
