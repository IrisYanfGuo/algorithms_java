package datastru;

/**
 * Class Stack , with the initialize compacity 10. based on Vector
 * version:2.0 18th Nov
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class Stack <E>{
	
	private Vector <E>data;
	private int compacity = 10;

	public Stack() {
		// TODO Auto-generated constructor stub

		data = new Vector<E>(compacity);
	}
	
	public void push(E o){
		data.addFirst(o);
	}
	
	public E pop(){
		E t = data.getLast();
		data.removeLast();
		return t;
	}
	
	public E top() {
		return data.getLast();
	}
	
	public int size() {
		return data.size();
	}
	
	private boolean isEmpty() {
		return data.isEmpty();
	}

}
