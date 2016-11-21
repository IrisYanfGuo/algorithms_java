package datastru;

/**
 * Class PriorityQueue based on unsortedList
 * version:2.0  2016/11/19
 * @author Yanfang Guo <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class PriorityQueueUnsorted<E>   {

    /**
     * The type Priority pair. it is the element of the priority queue.
     */
    public class PriorityPair<E> implements Comparable
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

        public int compareTo(Object O) {
            PriorityPair p2 = (PriorityPair) O;
            return ((Comparable)priority).compareTo(p2.priority);
        }

    }

    private LinkedList<PriorityPair> data;

    /**
     * Instantiates a new Priority queue.
     */
    public PriorityQueueUnsorted() {
        data = new LinkedList<PriorityPair>();
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
        data.addFirst(a);
        // make a pair of o and priority
        // add this pair to the sorted linked list.
    }

    /**
     * Pop object. pop the element with the highest priority
     *
     * @return the element of the priority
     */

    public PriorityPair pop(){
        return data.popPriority();
    }


    public PriorityPair pop1(){
        int pos =0;
        int prio =1000;
        for (int i = 0;i<data.size();i++){
            if (prio<data.get(i).priority){
                prio = data.get(i).priority;
                pos = i;
            }
        }

        return data.remove(pos);
    }
    /**
     * Top object.
     *
     * @return the top of the queue
     */
    public PriorityPair top() {
        return data.getFirst();
    }

    /**
     * Print the entire queue.
     */
    public void print(){
        data.print();
    }
}
