/**
 * ClassName:PriorityQueueBiTree
 * Version:1.0
 * Time : 00:32 29.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */


public class PriorityQueueBiTree {
    public class PrioPair implements Comparable {
        private Object el;
        private Comparable priority;

        @Override
        public String toString() {
            return
                    "element=" + el +
                            ", priority=" + priority;
        }

        public PrioPair(Comparable el, int priority) {
            this.el = el;
            this.priority = priority;
        }


        // there appears a bug in this place， so you should have a full understanding of this function.
        public int compareTo(Object o) {
            PrioPair a = (PrioPair) o;
            return priority.compareTo(a.priority);
        }


    }

    private BinaryTree data;

    public PriorityQueueBiTree() {
        data = new BinaryTree();
    }

    public void push(Comparable o, int priority) {
        PrioPair t = new PrioPair(o, priority);
        data.insertNode(t);
    }

    public Comparable pop() {
        Comparable t = data.getSmaill();
        data.remove(data.getSmaill());
        return t;
    }

    public void print() {
        data.printLeft();
    }


}
