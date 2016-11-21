package socialNetwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * A Main class is where i test all my classes version:1.0 time 21th Nov
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		Message aMessage = new UserMsg("first message content", "first message ", 0, 0);
		Message m2 = new Ad(" Second message content", "second message ", 0, 0);
		Message m3 = new Ad(" third message content", "third message ", 0, 0);
		Message m4 = new Ad(" forth message content", "forth message ", 0, 0);
		m2.print();
		m3.print();

		Network net = new Network();
		net.createUserProfile("ua", 10);
		net.createUserProfile("ub", 11);
		net.createUserProfile("uc", 12);

		net.createCorporateProfile("ca");
		net.createCorporateProfile("cb");
		net.postMessage("ua", "haha", 0, 0, 0);
		net.postMsgAll("ua", "hahah", 0, 0, 0);
		net.printWall("ua");
		net.printWall("ub");
		
		

		//may change the directory 
		BufferedReader readUser = new BufferedReader(new FileReader("C:/Users/yanfguo/workspace/socialNetw/src/socialNetwork/user.txt"));
		String line = readUser.readLine();
		while (line != null) {
			String[] string1 = line.split(" ");
			net.createUserProfile(string1[0],Integer.parseInt(string1[1]));
			System.out.println(line);
			line = readUser.readLine();
		} 
		
		BufferedReader readMsg = new BufferedReader(new FileReader("C:/Users/yanfguo/workspace/socialNetw/src/socialNetwork/msg1.txt"));
		
		String line1 = readMsg.readLine();
		while (line1 != null) {
			net.postMsgAll(line1.split(" ")[0], line1.split(" ")[1], Integer.parseInt(line1.split(" ")[2]),Integer.parseInt(line1.split(" ")[3]),Integer.parseInt(line1.split(" ")[4]));
			System.out.println(line1);
			line1 = readMsg.readLine();
		} 
		
		net.printWall("userA");
	}
	


}
