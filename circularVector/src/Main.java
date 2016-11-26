public class Main {

    public static void main(String[] args) {
        CircularVector circularVector = new CircularVector(10);
        circularVector.addFirst(1);
        circularVector.addFirst(2);
        circularVector.addFirst(3);
        circularVector.addFirst(4);
        circularVector.addFirst(5);
        circularVector.addFirst(6);
        circularVector.addFirst(7);
        circularVector.addFirst(8);
        circularVector.addFirst(9);
        circularVector.addFirst(10);
        circularVector.addFirst(11);
        circularVector.addFirst(12);

        circularVector.print();
        System.out.println(circularVector.toString());
        circularVector.removeFirst();
        circularVector.addLast(11);
        circularVector.print();


        // test for circularList
        CircularList alist = new CircularList();
        alist.addFirst(1);
        alist.addLast(2);
        alist.addFirst(3);
        alist.print();



    }
}
