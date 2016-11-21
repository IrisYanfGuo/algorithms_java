package socialNetwork;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * A Main class is where i test all my classes
 * version:1.0 time 7th Nov
 *
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
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

        File file = new File("/src/socialNetwork/user.txt");
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }

        }


    }

}
