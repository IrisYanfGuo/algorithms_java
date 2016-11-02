package stacks;

import java.util.Vector;

public class Stack {
	
	private Vector data;

	public Stack() {
		// TODO Auto-generated constructor stub
		data = new Vector();
	}
	
	public void push(Object o){
		data.addElement(o);
	}
	
	public Object pop(){
		Object t = data.lastElement();
		data.remove(data.size()-1);
		return t;
	}
	
	public Object top() {
		return data.lastElement();
	}
	
	public int size() {
		return data.size();
	}
	
	private boolean empty() {
		return data.isEmpty();
	}
	
	

}
