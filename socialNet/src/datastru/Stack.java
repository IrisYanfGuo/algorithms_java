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

	public Stack(Vector<E> v){
		data = v;
	}
	
	public void push(E o){
		data.addLast(o);
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
	
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public String toString() {
		return "Stack{" +
				"data=" + data +
				'}';
	}

	public Stack<E> deepcopy(){
		Vector<E> t = data.deepcopy();
		Stack<E> s = new Stack<E>(t);
		return s;
	}
}
