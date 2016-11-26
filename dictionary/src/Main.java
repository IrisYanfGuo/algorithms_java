/**
 * Created by Iris on 2016/11/14.
 */
public class Main {
    public static void main(String[] args){
        Dictionary dict = new Dictionary();
        dict.add("a",1);
        dict.add("b",2);
        dict.add("c",3);
        dict.add("a",4);

        System.out.print(dict.toString());
        }

}
