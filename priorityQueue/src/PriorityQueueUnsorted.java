/**
 * Created by Iris on 2016/11/14.
 * this is  a  priority queue based on unsorted list
 */
public class PriorityQueueUnsorted extends PriorityQueue  {

    /**
     * The type Priority pair. it is the element of the priority queue.
     */
    public class PriorityPair implements Comparable
    {

        public Object element;

        /**
         * The Priority. with smaller number one with the highest priority.
         */
        public Object priority;

        /**
         * Instantiates a new Priority pair.
         *
         * @param element  the element
         * @param priority the priority
         */
        public PriorityPair(Object element, Object priority) {
            this.element = element;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return
                    "element=" + element +
                            ", priority=" + priority;
        }

        public int compareTo(Object O) {
            PriorityPair p2 = (PriorityPair) O;
            return ((Comparable)priority).compareTo(p2.priority);
        }

    }

    private LinkedList data;

    /**
     * Instantiates a new Priority queue.
     */
    public PriorityQueueUnsorted() {
        data = new LinkedList();
    }

    /**
     * Push. add elements to a priority queue
     *
     * @param o        the o
     * @param priority the priority
     */
    public void push(Object o, int priority)
    {
        PriorityPair a = new PriorityPair(o,priority);
        data.addFirst(o);
        // make a pair of o and priority
        // add this pair to the sorted linked list.
    }

    /**
     * Pop object. pop the element with the highest priority
     *
     * @return the element of the priority
     */
    public Object pop()
    {
        return data.popPriority();
    }

    /**
     * Top object.
     *
     * @return the top of the queue
     */
    public Object top() {
        return data.getFirst();
    }

    /**
     * Print the entire queue.
     */
    public void print(){
        data.print();
    }
}
