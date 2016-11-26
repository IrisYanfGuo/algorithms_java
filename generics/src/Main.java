/**
 * Created by Iris on 2016/11/15.
 */
public class Main {
    public static void main(String[] argv){
        LinkedList<String> a = new LinkedList<String>();
        generic g1 = new generic();
        generic g2 = new generic();

        a.addFirst("HAHAH");
        a.addFirst("HAHAHA");

        System.out.println( a.getFirst().concat("HAHA"));

    }
}
