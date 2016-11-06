package socialNetworks;



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

	public void post( Message m	) {
		wall.addFirst(m);
	}

	
}
