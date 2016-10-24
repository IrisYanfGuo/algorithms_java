package linklist;
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

}
