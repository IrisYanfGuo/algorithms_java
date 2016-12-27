/**
 * ClassName:Test
 * Version:1.0
 * Time : 22:39 10.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        SplayTree a= new SplayTree();
        a.insert(1);
        a.preOrder();
        a.insert(5);
        a.preOrder();
        a.insert(3);
        a.preOrder();
        a.insert(6);
        a.preOrder();
        a.insert(8);
        a.preOrder();
        a.insert(60);

        a.preOrder();
        a.insert(24);
        a.preOrder();

        a.preOrder();
    }

}
