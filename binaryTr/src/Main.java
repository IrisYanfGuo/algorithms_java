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
        binaryTree.insertNode(8);
        binaryTree.insertNode(4);
        binaryTree.insertNode(12);
        binaryTree.insertNode(2);
        binaryTree.insertNode(3);
        binaryTree.insertNode(6);
        binaryTree.insertNode(10);
        //binaryTree.insertNode(8);

        binaryTree.insertNode(14);
        binaryTree.insertNode(1);
        binaryTree.insertNode(3);
        binaryTree.insertNode(5);
        binaryTree.insertNode(7);
        binaryTree.insertNode(9);
        binaryTree.insertNode(11);
        binaryTree.insertNode(13);
        binaryTree.insertNode(15);

        binaryTree.remove(8);

        binaryTree.printLayer();
        binaryTree.recPrint();
        binaryTree.printMid();

        //System.out.println(binaryTree.toString());




    }

}
