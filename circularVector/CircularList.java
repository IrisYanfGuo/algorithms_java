/**
 * Created by Iris on 2016/11/7.
 */
public class CircularList <E>{
    private  class ListElement {
        private E el1;
        private ListElement el2;

        /**
         * Instantiates a new List element.
         * Use a inner class,
         *
         * @param el          the el, the object
         * @param nextElement the next element
         */
        public ListElement(E el, ListElement nextElement) {
            el1 = el;
            el2 = nextElement;
        }

        /**
         * Instantiates a new List element with only one parameter, with the nextelement is null.
         *
         * @param el the el
         */
        public ListElement(E el) {
            this(el, null);
        }

        /**
         * First object.
         *
         * @return the object, the contant in each unit.
         */
        public E first() {
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
        public void setFirst(E value) {
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
    private  ListElement tail;

    /**
     * Instantiates a new Circular list.
     */
    public CircularList() {
        head = null;
        tail = null;
    }

    /**
     * Add element on from the head
     *
     * @param o the o
     * @return the circular list
     */
    public CircularList addFirst(E o){
        if (head == null){
            head = new ListElement(o,head);
            tail = head;
        }else{
            head = new ListElement(o,head);

        }
        return this;
    }

    /**
     * Add last element on the tail
     *
     * @param o the o
     * @return the circular list
     */
    public CircularList addLast(E o){
        if( tail == null){
            tail = new ListElement(o,tail);
            head = tail;
        }else {
            tail.setRest(new ListElement(o,head));
            tail =tail.rest();
        }
        return this;
    }

    @Override
    /**
     * using the listElement toString method, which print the el1.
     */
    public String toString() {
        String s = "(";
        ListElement d = head;
        while (d != tail) {
            s += d.first().toString();
            s += " ";
            d = d.rest();
        }
        s += tail.first().toString();
        s += ")";
        return s;
    }

    /**
     * Print circular list,using the function toString
     *
     * @return the circular list
     */
    public CircularList print() {
        System.out.print(toString());
        System.out.println();
        return this;
    }
}
