package queue;

import java.util.Vector;

public class Queue {
	private Vector data;

	public Queue() {
		// TODO Auto-generated constructor stub
		data = new Vector();
	}
	
	public void push(Object o) {
		data.add(o);
	}
	
	public Object pop() {
		Object t = data.get(0);
		for (int i = 0; i < data.size()-1; i++) {
			data.set(i, data.get(i+1));
		}
		data.remove(data.size()-1);
		return t;
		
	}
	
	public Object top() {
		return data.get(0);
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean empty() {
		return data.isEmpty();
	}
	
	public void print() {
		for (int i = 0; i < data.size(); i++) {
			System.out.print(data.get(i).toString()+' ');
		}
		System.out.println();
	}

}
