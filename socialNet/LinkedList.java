package socialNetworks;

/**a linked list is a linear collection of data elements, called nodes, each pointing to the next 
 * node by means of a pointer. It is a data structure consisting of a group of nodes 
 * which together represent a sequence. Under the simplest form, each node is composed of 
 * data and a reference (in other words, a link) to the next node in the sequence. This structure allows 
 * for efficient insertion or removal of elements from any position in the sequence during iteration. 
 * More complex variants add additional links, allowing efficient insertion or removal from arbitrary element references.
 * to know more details visit: https://en.wikipedia.org/wiki/Linked_list
 * 
 * version:1.0 time 7th Nov
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class LinkedList {

	private  class ListElement {
		private Object el1;
		private ListElement el2;

		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Object el) {
			this(el, null);
		}

		public Object first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		@SuppressWarnings("unused")
		public void setFirst(Object value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}

		/*
		 * public String toString(){ String s = null; s= s+el1; return s; }
		 */
	}

	private ListElement head;

	public LinkedList() {
		head = null;
	}

	public void addFirst(Object o) {
		head = new ListElement(o, head);

	}

	public Object getFirst() {
		return head.first();
	}

	public Object get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}

	public String toString() {
		String s = "";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		return s;
	}

	/*
	 * public void print() { LinkedList.ListElement temp; temp = head; do {
	 * System.out.println(temp.el1); temp=temp.el2; }while (temp!=null); }
	 */
	public LinkedList print() {
		System.out.print(toString());
		System.out.println();
		return this;
	}

	public int size() {
		int size = 0;
		ListElement t = head;
		while (t != null) {
			size += 1;
			t = t.el2;
		}
		return size;
	}

	// Add a method set(int n, Object o) which replaces the nth element in the
	// list.
	public LinkedList set(int index, Object o) {
		int t = 1;
		ListElement p = head;
		while (t != index) {
			p = p.el2;
			t += 1;
		}
		p.el1 = o;
		return this;
	}

	// Add a method getLast() which returns the last element in the list.
	public ListElement getLast() {
		ListElement p = head;
		while (p.el2 != null) {
			p = p.el2;
		}
		return p;
	}
	// Add a method addLast() which adds an element to the end of the linked
	// list.

	public LinkedList addLast(Object o) {
		ListElement t = getLast();
		t.el2 = new ListElement(o);
		return this;
	}

	// searches for a given element in the linked list.
	public ListElement search(Object o) {
		ListElement p = head;
		while (p.el1 != o) {
				p=p.el2;		
		}
		return p;
	}

	/*
	 * public LinkedList fropple() { ListElement p = head; while(p!=null){
	 * p.el2.el2 = p; p.el2 =p.el2.el2; p = p.el2.el2; } return this;
	 * 
	 * }
	 */ // error, infinite loop


	public void append(LinkedList l2) {
		getLast().el2=l2.head;
	}
	
	public LinkedList fropple() {
		if (head!=null&&head.rest()!=null) {
			ListElement t1=head;
			ListElement t2 = head.rest();
			head = t2;	
			ListElement t3;
			
			while (t1!=null&&t2!=null) {
				t3 = t2.rest();
				t1.setRest(t2.rest());
				t2.setRest(t1);
				
				if (t3 == null)
				{break;}if (t3.rest()!=null) {
					t1.setRest(t3.rest());
					t1=t3;
					t2= t1.rest();
				} else {
					t1 = t3;
					t2= t1.rest();
				}
			}
			
		}
		return this;				
	}
	
	public LinkedList fropple1() {
		ListElement p =head;
		while(p.rest()!=null&&p!=null){
			Object t;
			t=p.first();
			p.setFirst(p.rest().first());
			p.rest().setFirst(t);
			p=p.rest().rest();
		}
		return this;
	}

}
