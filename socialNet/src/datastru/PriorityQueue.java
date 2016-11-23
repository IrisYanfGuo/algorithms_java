package datastru;

/**
 * Class PriorityQueue
 * version:2.0  2016/11/19
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class PriorityQueue<E>
{
	/**
	 * The type Priority pair. it is the element of the priority queue.
	 */
	public class PriorityPair implements Comparable
	{

		public E element;

		/**
		 * The Priority. with smaller number one with the highest priority.
		 */
		public int priority;

		/**
		 * Instantiates a new Priority pair.
		 *
		 * @param element  the element
		 * @param priority the priority
		 */
		public PriorityPair(E element, int priority) {
			this.element = element;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return
					"element=" + element +
					", priority=" + priority;
		}

		public void print(){
			System.out.println(element.toString());
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable)priority).compareTo(p2.priority);
		}

		public E getElement() {
			return this.element;
		}
	}

	private LinkedList<PriorityPair> data;

	/**
	 * Instantiates a new Priority queue.
	 */
	public PriorityQueue() {
		data = new LinkedList<>();
	}


	public LinkedList<PriorityPair> getData() {
		return data;
	}


	/**
	 * Push. add elements to a priority queue
	 *
	 * @param o        the o
	 * @param priority the priority
	 */
	public void push(E o, int priority)
	{
		PriorityPair a = new PriorityPair(o,priority);
		data.addSorted(a);
		// make a pair of o and priority
		// add this pair to the sorted linked list.
	}

	/**
	 * Pop object. pop the element with the highest priority
	 *
	 * @return the element of the priority
	 */
	public E pop()
	{
		return data.popFirst().getElement();
	}

	/**
	 * Top object.
	 *
	 * @return the top of the queue
	 */
	public E top() {
		return data.getFirst().getElement();
	}

	/**
	 * Print the entire queue.
	 */
	public void print(){
		data.print();
	}

	public int size(){
		return getData().size();
	}
}
