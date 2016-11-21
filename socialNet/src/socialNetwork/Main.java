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



		Network net = new Network();

		
		//create some users , initialize
		//may change the directory 
		BufferedReader readUser = new BufferedReader(new FileReader("./src/socialNetwork/user.txt"));
		String line = readUser.readLine();
		while (line != null) {
			String[] string1 = line.split(" ");
			net.createUserProfile(string1[0],Integer.parseInt(string1[1]));
			System.out.println(line);
			line = readUser.readLine();
		} 


		//post some messages to all users
		BufferedReader readMsg = new BufferedReader(new FileReader("./src/socialNetwork/msg1.txt"));
		
		String line1 = readMsg.readLine();
		while (line1 != null) {
			net.postMsgAll(line1.split(" ")[0], line1.split(" ")[1], Integer.parseInt(line1.split(" ")[2]),Integer.parseInt(line1.split(" ")[3]),Integer.parseInt(line1.split(" ")[4]));
			System.out.println(line1);
			line1 = readMsg.readLine();
		}


		//create some companys , initialize
		BufferedReader readCom = new BufferedReader(new FileReader("./src/socialNetwork/company.txt"));

		String line2 = readCom.readLine();
		while (line2 != null) {
			System.out.println(line2);
			net.createCorporateProfile(line2);
			line2 = readCom.readLine();
		}

		net.printUsr();
		net.printCom();
		net.printWall("userB");
		net.printWall("ua");
	}
	


}
