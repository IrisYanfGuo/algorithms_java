package socialNetworks;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Message aMessage = new Message("first message content", "first message author", 0, 0, 0);
		Message m2 = new Message(" Second message content","second message author",0,0,0);
		Message m3 = new Message(" third message content","third message author",0,0,0);
		Message m4 = new Message(" forth message content","forth message author",0,0,0);
		
		
		Profile aProfile =new Profile("guoguo", 0);
		aProfile.post(aMessage);
		aProfile.post(m2);
		aProfile.post(m3);
		aProfile.post(m4);
		aProfile.wall.print();
		
	}

}
