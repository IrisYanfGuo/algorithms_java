
public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector myVector = new Vector(100);
		// 1.1 add the elements 1 to 100
		for (int i = 1; i < 101; i++)
			myVector.addLast(i);
		// 1.2 get the size of the vector and check whether the vector contains
		// 6 and 101
		System.out.println(myVector.size());
		System.out.println(myVector.contains(6));
		System.out.println(myVector.contains(101));
		// test getFirst and getLast
		System.out.println(myVector.getFirst());
		System.out.println(myVector.getLast());
		// test the method print

		myVector.print();

		myVector.addFirst('h');
		myVector.print();
		myVector.removeFirst();
		myVector.print();
		myVector.addLast(101);
		myVector.print();
		myVector.removeLast();
		myVector.print();
		myVector.addLast(101);
		myVector.reverse();
		myVector.print();
		myVector.interleaves(myVector).print();
	}

}
