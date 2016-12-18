package datastru;

/**
 * Class Stack , with the initialize compacity 10. based on Vector
 * version:2.0 18th Nov
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */

public class Queue<E> {
	private Vector<E> data;

	public Queue() {
		// TODO Auto-generated constructor stub
		data = new Vector<E>();
	}
	
	public void push(E o) {
		data.addLast(o);
	}
	
	public E pop() {
		E t = data.get(0);
		for (int i = 0; i < data.size()-1; i++) {
			data.set(i, data.get(i+1));
		}
		data.removeLast();
		return t;
		
	}
	
	public E top() {
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
