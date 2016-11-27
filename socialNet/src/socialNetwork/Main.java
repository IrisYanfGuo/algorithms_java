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





		/////////////////////////// initialize///////////////////////////////////////
		///using the .txt file to initialize, create some users,companys , and posted some msgs and ads,then print///
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
			String content = line1.split(" ")[0];
			String author = line1.split(" ")[1];
			int ageLimit = Integer.parseInt(line1.split(" ")[2]);
			int privacy  = Integer.parseInt(line1.split(" ")[3]);
			UserMsg msg = new UserMsg(content,author,ageLimit,privacy,0);
			net.postMsgAll(msg,msg.getPrivacy(),msg.getAgeLimit());
			line1 = readMsg.readLine();
		}
		System.out.print("read Msg from msg.txt completed\npost these msgs to all users");


		//create some companys , initialize
		BufferedReader readCom = new BufferedReader(new FileReader("./src/socialNetwork/company.txt"));

		String line2 = readCom.readLine();
		while (line2 != null) {
			net.createCorporateProfile(line2);
			line2 = readCom.readLine();
		}
		System.out.print("read company profile from company.txt completed");
		//create some ads ,initialize
		BufferedReader readAd= new BufferedReader(new FileReader("./src/socialNetwork/ad.txt"));

		String line3 = readAd.readLine();
		while (line3 != null) {
			String content = line3.split(" ")[0];
			String author = line3.split(" ")[1];
			int ageLimit = Integer.parseInt(line3.split(" ")[2]);
			boolean paid  = Boolean.parseBoolean(line3.split(" ")[3]);
			Ad ad= new Ad(content,author,ageLimit,0,paid);
			net.postAdAll(ad,author,ageLimit,paid);
			line3 = readAd.readLine();
		}
		System.out.print("read ads from ad.txt completed\n post these ads to all users");


		///////////////////////////initialize finished////////////////////////////



		net.findUser("userB").printADlist();
		net.findUser("userB").printUseMsgList();

		net.printUsr();
		net.printCom();
		net.printWall("userB");
		net.printWall("ua");





	}



}
