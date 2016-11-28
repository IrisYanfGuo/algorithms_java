/**
 * ClassName:Main
 * Version:1.0
 * Time : 13:48 28.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Main {
    public Main() {
    }

    public static void mainLList(String[] args) {
        LinkedList oLinkedList = new LinkedList();

        oLinkedList.addFirst(1);
        oLinkedList.addFirst(2);
        oLinkedList.addFirst(3);
        oLinkedList.addFirst(4);

        oLinkedList.print();
        //System.out.println(oLinkedList.size());

        oLinkedList.set(2, 5);
        oLinkedList.addLast(8).print();
        oLinkedList.fropple();
        oLinkedList.print();
        LinkedList l2 =new LinkedList();
        l2.addFirst(3);
        l2.addFirst(4);
        oLinkedList.append(l2);
        oLinkedList.print();
        oLinkedList.fropple1();
        oLinkedList.print();
    }

    public static void mainQu(String[] args){
        Queue aQueue = new Queue();
        aQueue.push(2);
        aQueue.push(3);
        aQueue.push(6);
        aQueue.push(5);
        aQueue.print();
        aQueue.pop();
        aQueue.push(7);
        aQueue.print();
        System.out.println(aQueue.size());
    }

    public static void mainPriQu(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.push("1st",1);
        pq.push("2nd",2);
        pq.push("3rd",3);
        pq.push("1st",1);
        pq.print();
        pq.pop();
        System.out.println(pq.pop());
        pq.print();

        PriorityQueueUnsorted pqus = new PriorityQueueUnsorted();
        pqus.push("4th",4);
        pqus.push("2nd",2);
        pqus.push("3rd",3);
        pqus.push("1st",1);
        pqus.push("4th",4);
        pqus.push("3rd",3);
        pqus.push("4th",4);
        pqus.print();
        pqus.pop();
        pqus.print();
        System.out.println(pqus.pop());
        pqus.print();
        pqus.pop();
        pqus.print();
    }

    public static  void mainCirList(String[] args){
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

    public static void mainStack(String[] args){
        Stack aStack = new Stack();
        aStack.push(2);
        aStack.push(3);
        aStack.push(6);
        aStack.push(5);
        System.out.println(aStack.size());
        aStack.pop();
        System.out.println(aStack.pop());
        System.out.println(aStack.top());
        System.out.println(aStack.size());
    }

    public static void mainDLList(String[] args){
        DoubleLinkedList a = new DoubleLinkedList();
        a.addFirst(4);
        a.addFirst(3);
        a.addFirst(2);
        a.addFirst(1);

        a.print();

        a.reverse();
        a.print();

        a.printReverse();

        a.removeFirst();
        a.print();

        a.removeLast();
        a.print();

        a.reverse();
        a.print();


    }
    
    public static void main(String[] args){

    }

}
