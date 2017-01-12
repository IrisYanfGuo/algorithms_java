package socialNetwork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        BufferedReader readUser = new BufferedReader(new FileReader("./src/txt/user.txt"));
        String line = readUser.readLine();
        while (line != null) {
            String[] string1 = line.split(" ");
            net.createUserProfile(string1[0], Integer.parseInt(string1[1]));
            //   System.out.println(line);
            line = readUser.readLine();
        }


        //post some messages to all users
        BufferedReader readMsg = new BufferedReader(new FileReader("./src/txt/msg1.txt"));

        String line1 = readMsg.readLine();
        while (line1 != null) {
            String content = line1.split(" ")[0];
            String author = line1.split(" ")[1];
            int ageLimit = Integer.parseInt(line1.split(" ")[2]);
            int privacy = Integer.parseInt(line1.split(" ")[3]);
            UserMsg msg = new UserMsg(content, author, ageLimit, privacy);
            net.postMessage(msg, msg.getPrivacy(), msg.getAgeLimit());
            line1 = readMsg.readLine();
        }
        System.out.print("read Msg from msg.txt completed\npost these msgs to all users");


        //create some companys , initialize
        BufferedReader readCom = new BufferedReader(new FileReader("./src/txt/company.txt"));

        String line2 = readCom.readLine();
        while (line2 != null) {
            net.createCorporateProfile(line2);
            line2 = readCom.readLine();
        }
        System.out.print("read company profile from company.txt completed");



        //  users add  rate to companys


        BufferedReader readRate = new BufferedReader(new FileReader("./src/txt/rate.txt"));

        String line5 = readRate.readLine();
        while (line5 != null) {
            String user1 = line5.split(" ")[0];
            String com = line5.split(" ")[1];
            int rate = Integer.parseInt(line5.split(" ")[2]);
            net.rate(user1, com, rate);
            line5 = readRate.readLine();
        }
        System.out.print("read rates from connect.txt completed\n connect these users\n");
        System.out.println("initialize completed!");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        //create some ads ,initialize
        BufferedReader readAd = new BufferedReader(new FileReader("./src/txt/ad.txt"));

        String line3 = readAd.readLine();
        while (line3 != null) {
            String content = line3.split(" ")[0];
            String author = line3.split(" ")[1];
            int ageLimit = Integer.parseInt(line3.split(" ")[2]);
            boolean paid = Boolean.parseBoolean(line3.split(" ")[3]);
            Ad ad = new Ad(content, author, ageLimit, paid);
            net.postAD(ad, author, ageLimit, paid);
            line3 = readAd.readLine();
        }
        System.out.print("read ads from ad.txt completed\n post these ads to all users\n");


        ///////////////////////////initialize finished////////////////////////////
        // net.findUser("userB").printADlist();
        // net.findUser("userB").printUseMsgList();

        //print all users and companys
        //  net.printUsr();
        // net.printCom();


        // connect some users

        BufferedReader readConnect = new BufferedReader(new FileReader("./src/txt/connect.txt"));

        String line4 = readConnect.readLine();
        while (line4 != null) {
            String user1 = line4.split("   ")[0];
            String user2 = line4.split("   ")[1];
            net.connect(user1, user2);
            line4 = readConnect.readLine();
        }
        System.out.print("read ads from connect.txt completed\n connect these users\n");




//////////////////////////initialize completed///////////////////////////////////////////////////////

        System.out.println("most functions written in part1 and part2 are used in part3 or part4, so when the functions ");
        System.out.println("in part3 and part4 are teated, functions in part1 and part2 are tested too!");
        System.out.println("test  functions");
        System.out.println();
        System.out.println("1.test print friendlist");
        net.printFriendList("userA");
        System.out.println();
        System.out.println();


        System.out.println("2.test print wall");
        net.printWall("userZ");
        System.out.println();
        System.out.println();


        System.out.println("3.test distance function");
        System.out.println("3.1 test the social graph with company");
        System.out.print("distance :");
        System.out.println(net.distance("userA", "userZ"));

        net.printPath("userA","userZ");

        System.out.println(net.distanceExcludeCorporate("userA", "userZ"));
        net.printPathExcludeCorporate("userA", "userZ");
        System.out.println();


        System.out.println("4.test rate");
         net.printWall("userF");

        //  net.printWall("userB");

        //  net.findUser("haha");

        System.out.println(TimeStamp.getTimeStamp());
        System.out.println(net.findByName("userF").rateVector);
        Ad aad = new Ad("test","companyE",0,false);
        net.postAdByUser("userF",aad,0,false);
        net.findUser("userF").printADlist();
    //    net.printWall("userF");


    }


}
