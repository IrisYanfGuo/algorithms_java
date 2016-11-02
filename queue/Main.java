package queue;

import queue.Queue;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

}

