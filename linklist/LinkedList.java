import java.util.Comparator;

/**
 * The type Linked list.
 */
public class LinkedList {

	private  class ListElement {
		private Object el1;
		private ListElement el2;

		/**
		 * Instantiates a new List element.
		 * Use a inner class,
		 *
		 * @param el          the el, the object
		 * @param nextElement the next element
		 */
		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		/**
		 * Instantiates a new List element with only one parameter, with the nextelement is null.
		 *
		 * @param el the el
		 */
		public ListElement(Object el) {
			this(el, null);
		}

		/**
		 * First object.
		 *
		 * @return the object, the contant in each unit.
		 */
		public Object first() {
			return el1;
		}

		/**
		 * Rest list element.
		 *
		 * @return the the nextelement ,which points to the rest of the list
		 */
		public ListElement rest() {
			return el2;
		}

		/**
		 * Sets the el1
		 *
		 * @param value the value
		 */
		@SuppressWarnings("unused")
		public void setFirst(Object value) {
			el1 = value;
		}

		/**
		 * Sets the el2,which  indicates the rest elements
		 *
		 * @param value the value
		 */
		public void setRest(ListElement value) {
			el2 = value;
		}

		/*
		 * public String toString(){ String s = null; s= s+el1; return s; }
		 */
	}


	private ListElement head;

	/**
	 * Instantiates a new Linked list.
	 */
	public LinkedList() {
		head = null;
	}


	/**
	 * Add first, add from the head.
	 *
	 * @param o the o
	 */
	public void addFirst(Object o) {
		head = new ListElement(o, head);

	}

	/**
	 * Gets first.
	 *
	 * @return the first
	 */
	public Object getFirst() {
		return head.first();
	}

	/**
	 * Get object with index n.
	 *
	 * @param n the n
	 * @return the object
	 */
	public Object get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}

	public String toString() {
		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += ")";
		return s;
	}

	/**
	 * Print linked list.
	 *
	 * @return the linked list
	 */
/*
	 * public void print() { LinkedList.ListElement temp; temp = head; do {
	 * System.out.println(temp.el1); temp=temp.el2; }while (temp!=null); }
	 */
	public LinkedList print() {
		System.out.print(toString());
		System.out.println();
		return this;
	}

	/**
	 * return the size of the linked list
	 *
	 * @return the int
	 */
	public int size() {
		int size = 0;
		ListElement t = head;
		while (t != null) {
			size += 1;
			t = t.el2;
		}
		return size;
	}

	/**
	 * Set linkedlist element n with the index n
	 *
	 * @param index the index
	 * @param o     the o
	 * @return the linked list
	 */
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

	/**
	 * Get the el2 which point to the last element.
	 *
	 * @return the last
	 */
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

	/**
	 * Add objects to linked list from the end
	 *
	 * @param o the o
	 * @return the linked list
	 */
	public LinkedList addLast(Object o) {
		ListElement t = getLast();
		t.el2 = new ListElement(o);
		return this;
	}

	/**
	 * Search list element with the object given and return the el2 point to this.
	 *
	 * @param o the o
	 * @return the list element
	 */
// searches for a given element in the linked list.
	public ListElement search(Object o) {
		ListElement p = head;
		while (p.el1 != o) {
				p=p.el2;		
		}
		return p;
	}

	/**
	 * Pop first object.
	 *
	 * @return the object
	 */
	public Object popFirst(){
		Object t = head.el1;
		head= head.el2;
		return t;
	}

	/**
	 * Pop last object.
	 *
	 * @return the object
	 */
	public  Object popLast(){
		ListElement p = head;
		while (p.el2.el2 != null) {
			p = p.el2;
		}
		Object t = p.rest().first();
		p.setRest(null);
		return t;
	}
	/*
	 * public LinkedList fropple() { ListElement p = head; while(p!=null){
	 * p.el2.el2 = p; p.el2 =p.el2.el2; p = p.el2.el2; } return this;
	 * 
	 * }
	 */ // error, infinite loop


	/**
	 * Append. add something to linkedlist. combine 2 linked list.
	 *
	 * @param l2 the l 2
	 */
	public void append(LinkedList l2) {
		getLast().el2=l2.head;
	}

	/**
	 * Fropple linked list.
	 *
	 * @return the linked list
	 */
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

	/**
	 * the second way to fropple linked list.
	 *
	 * @return the linked list
	 */
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


	/**
	 * Add sorted. this is used in the Priority Queue. add with priority.
	 *
	 * @param o the o
	 */
	public void addSorted(Comparable o){
		if(head == null){
			head = new ListElement(o,null);
		} else  if (((Comparable)head.first()).compareTo(o)>0){
			head = new ListElement(o,head);
		} else{
			ListElement d = head;
			while((d.rest()!= null)&&((Comparable)d.rest().first()).compareTo(o)<0){
				d=d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o,next));
		}

	}

}
