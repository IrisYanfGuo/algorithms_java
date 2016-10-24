package socialNetworks;

import java.nio.channels.GatheringByteChannel;

public class Profile {

	private String username;
	private int age;
	public Message[] wall;

	public Profile() {
		// TODO Auto-generated constructor stub
	}

	public Profile(String username, int age) {
		this.age = age;
		this.username = username;

	}

	@Override
	public String toString() {
		return "Profile []";
	}

	public void post() {

	}

	public void print() {
	}

	public void printa() {

	}

}
