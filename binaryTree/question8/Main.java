/**
 * ClassName:Main
 * Version:1.0
 * Time : 13:24 26.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(4,4);
        binaryTree.insertNode(1,1);
        binaryTree.insertNode(3,7);
        binaryTree.insertNode(6,2);
        binaryTree.insertNode(8,6);
        binaryTree.insertNode(1,5);
        binaryTree.insertNode(5,8);
        binaryTree.insertNode(2,6);

        binaryTree.printMid();




        //System.out.println(binaryTree.toString());




    }

}
